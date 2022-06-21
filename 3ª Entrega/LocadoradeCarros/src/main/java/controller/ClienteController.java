package controller;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modal.ClienteDTO;
import modal.ClienteDAO;

public class ClienteController implements Initializable {
	
	
    @FXML
    private TabPane abas;

    @FXML
    private Tab atualizarCliente;

    @FXML
    private TableView<ClienteDTO> tabelaCliente;
    
    @FXML
    private TableColumn<ClienteDTO, Integer> colClienteId;
    
    @FXML
    private TableColumn<ClienteDTO, String> colClienteNome;

    @FXML
    private TableColumn<ClienteDTO, String> colClienteCpf;

    @FXML
    private TableColumn<ClienteDTO, String> colClienteTelefone;

    @FXML
    private TableColumn<ClienteDTO, String> colClienteTotal;

    @FXML
    private Tab consultar;

    @FXML
    private Tab consultar1;

    @FXML
    private Label lblCpf;

    @FXML
    private TextField txtClienteConsultar;

    @FXML
    private TextField txtCpfCliente;

    @FXML
    private TextField txtCpfClienteEditar;

    @FXML
    private TextField txtTelefoneCliente;

    @FXML
    private TextField txtTelefoneClienteEditar;

    @FXML
    private TextField txtNomeCliente;

    @FXML
    private TextField txtNomeClienteEditar;

    @FXML
    private TextField txtTotalCliente;

    @FXML
    private TextField txtTotalClienteEditar;

    
    public void initialize(URL location, ResourceBundle resources) {
    	clienteDao = new ClienteDAO();
		
    	colClienteId.setCellValueFactory(new PropertyValueFactory<>("id_cliente"));
		colClienteNome.setCellValueFactory(new PropertyValueFactory<>("nomecli"));
		colClienteCpf.setCellValueFactory(new PropertyValueFactory<>("cpfcli"));
		colClienteTelefone.setCellValueFactory(new PropertyValueFactory<>("telefonecli"));
		colClienteTotal.setCellValueFactory(new PropertyValueFactory<>("totalcli"));
    }
    
    private ClienteDTO clienteSelecionado;
    private ClienteDAO clienteDao;
    
    //CADASTRAR ///////////////////////////////////////////////////////////////////
    @FXML
    void btnCadastrarCliente() {
    	ClienteDTO cliente = new ClienteDTO();
    	
    	cliente.setNomecli(txtNomeCliente.getText());
    	cliente.setCpfcli(txtCpfCliente.getText());
    	cliente.setTelefonecli(txtTelefoneCliente.getText());
		cliente.setTotalcli(txtTotalCliente.getText());
		try {
			clienteDao.cadastrarCliente(cliente);
			exibiDialogoINFO("Cliente cadastrado com sucesso!");
			txtNomeCliente.clear();
			txtCpfCliente.clear();
			txtTelefoneCliente.clear();
			txtTotalCliente.clear();
		} catch (Exception e) {
			exibiDialogoERRO("Falha ao cadastrar cliente!");
			e.printStackTrace();
		}
    }

    @FXML
    void btnLimparCliente() {
    	if (exibiDialogoConfirmacao("Todos os campos serão LIMPOS. Confirmar?")) {
    		txtNomeCliente.clear();
			txtCpfCliente.clear();
			txtTelefoneCliente.clear();
			txtTotalCliente.clear();
    	}
    }
    
    //CONSULTAR ///////////////////////////////////////////////////////////////////
    @FXML
    void btnClienteAtualizar() {
    	clienteSelecionado = tabelaCliente.getSelectionModel().getSelectedItem();
    	if (tabelaCliente.getSelectionModel().getSelectedItem()== null) {
			exibiDialogoERRO("Não há cliente selecionado!");

    	} else {
    		atualizarCliente.setDisable(false);
    		txtNomeClienteEditar.setText(clienteSelecionado.getNomecli());
    		txtCpfClienteEditar.setText(clienteSelecionado.getCpfcli());
    		txtTelefoneClienteEditar.setText(clienteSelecionado.getTelefonecli());
    		txtTotalClienteEditar.setText(clienteSelecionado.getTotalcli());
    	}
    }

    @FXML
    void btnClienteDeletar() {
    	if (tabelaCliente.getSelectionModel().getSelectedItem()== null) {
			exibiDialogoERRO("Não há cliente selecionado!");
    	} else {
    		
    		if (exibiDialogoConfirmacao("Confirmar a exclusão do cliente selecionado?")) {
    	  
    			try{
					clienteDao.deletarCliente(tabelaCliente.getSelectionModel().getSelectedItem().getId_cliente());;
					exibiDialogoINFO("CLIENTE deletado com sucesso!");
					txtClienteConsultar.clear();
					btnClienteConsultar();
    				}catch (Exception e) {
    			     exibiDialogoERRO("Falha ao deletar selecionado!");
    				}
    			}
    
    	}
    }

    @FXML
    void btnClienteConsultar() {
    	try {
    		List<ClienteDTO> resultado =  clienteDao.consultar(txtClienteConsultar.getText());
        	if(resultado.isEmpty()) {
        		exibiDialogoINFO("Nenhum cliente encontrado!");
        	}else {
        		tabelaCliente.setItems(FXCollections.observableArrayList(resultado));
        	}
		} catch (Exception e) {
			exibiDialogoERRO("Falha ao realizar a consulta!");
			e.printStackTrace();
		}
    }
    
    //EDITAR ///////////////////////////////////////////////////////////////////
    @FXML
    void btnClienteLimparAtt() {
    	if (exibiDialogoConfirmacao("Todos os campos serão LIMPOS. Confirmar?")) {
    		txtNomeClienteEditar.clear();
    		txtCpfClienteEditar.clear();
	    	txtTelefoneClienteEditar.clear();
	    	txtTotalClienteEditar.clear();
    	}
    }

    @FXML
    void btnClienteSalvarAtt() {
    	clienteSelecionado = tabelaCliente.getSelectionModel().getSelectedItem();
		
		clienteSelecionado.setNomecli(txtNomeClienteEditar.getText());
		clienteSelecionado.setCpfcli(txtCpfClienteEditar.getText());
		clienteSelecionado.setTelefonecli(txtTelefoneClienteEditar.getText());
		clienteSelecionado.setTotalcli(txtTotalClienteEditar.getText());
	    try {
			clienteDao.atualizarCliente(clienteSelecionado);
			exibiDialogoINFO("Cliente atualizado com sucesso!");
			abas.getSelectionModel().select(consultar);
			btnClienteConsultar();
			atualizarCliente.setDisable(true);
		} catch (Exception e) { 			
			exibiDialogoERRO("Falha ao atualizar cliente!");
		}
    }


    @FXML
    void gerenciarAbas(MouseEvent event) {
    	if(consultar.isSelected()) {
    		atualizarCliente.setDisable(true);
    	}
    }
    
    private void exibiDialogoINFO(String informacao) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Informacao");
    	alert.setHeaderText(null);
    	alert.setContentText(informacao);
    	
    	alert.showAndWait();
    }
    
     void exibiDialogoERRO(String erro) {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Erro");
    	alert.setHeaderText(null);
    	alert.setContentText(erro);
    	
    	alert.showAndWait();
     }

     private boolean exibiDialogoConfirmacao(String confirmacao) {
      	Alert alert = new Alert(AlertType.CONFIRMATION);
      	alert.setTitle("Confirmacao");
      	alert.setHeaderText(null);
      	alert.setContentText(confirmacao);
      	
      	Optional<ButtonType> opcao = alert.showAndWait();
      	
      	if(opcao.get() == ButtonType.OK)
      		return true;
      	return false;
      }

}
