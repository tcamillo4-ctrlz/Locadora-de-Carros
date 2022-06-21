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
import modal.FuncionarioDTO;
import modal.FuncionarioDAO;

public class FuncionarioController implements Initializable {
	
	@FXML
    private TabPane abas;

    @FXML
    private Tab atualizarFuncionario;

    @FXML
    private TableView<FuncionarioDTO> tabelaFuncionario;
    
    @FXML
    private TableColumn<FuncionarioDTO, Integer> colFuncionarioId;
    
    @FXML
    private TableColumn<FuncionarioDTO, String> colFuncionarioCargo;

    @FXML
    private TableColumn<FuncionarioDTO, String> colFuncionarioCpf;

    @FXML
    private TableColumn<FuncionarioDTO, String> colFuncionarioNome;

    @FXML
    private TableColumn<FuncionarioDTO, String> colFuncionarioSalario;

    @FXML
    private Tab consultar;

    @FXML
    private Tab consultar1;

    @FXML
    private Label lblCpfFuncionario;

    @FXML
    private TextField txtCargoFuncionario;

    @FXML
    private TextField txtCargoFuncionarioEditar;

    @FXML
    private TextField txtCpfFuncionario;

    @FXML
    private TextField txtCpfFuncionarioEditar;

    @FXML
    private TextField txtFuncionarioConsultar;

    @FXML
    private TextField txtNomeFuncionario;

    @FXML
    private TextField txtNomeFuncionarioEditar;

    @FXML
    private TextField txtSalarioFuncionario;

    @FXML
    private TextField txtSalarioFuncionarioEditar;

    public void initialize(URL location, ResourceBundle resources) {
    	funcDao = new FuncionarioDAO();
		
		colFuncionarioId.setCellValueFactory(new PropertyValueFactory<>("id_funcionario"));
		colFuncionarioNome.setCellValueFactory(new PropertyValueFactory<>("nomefunc"));
		colFuncionarioCpf.setCellValueFactory(new PropertyValueFactory<>("cpffunc"));
		colFuncionarioCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		colFuncionarioSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
    }
    
    private FuncionarioDTO funcSelecionado;
    private FuncionarioDAO funcDao;
    
    //CADASTRAR ///////////////////////////////////////////////////////////////////
    @FXML
    void btnCadastrarFuncionario() {
    	FuncionarioDTO func = new FuncionarioDTO();
    	
    	func.setNomefunc(txtNomeFuncionario.getText());
    	func.setCpffunc(txtCpfFuncionario.getText());
    	func.setCargo(txtCargoFuncionario.getText());
		func.setSalario(txtSalarioFuncionario.getText());
		try {
			funcDao.cadastrarFuncionario(func);
			exibiDialogoINFO("Funcionario cadastrado com sucesso!");
			txtNomeFuncionario.clear();
			txtCpfFuncionario.clear();
			txtCargoFuncionario.clear();
			txtSalarioFuncionario.clear();
		} catch (Exception e) {
			exibiDialogoERRO("Falha ao cadastrar funcionario!");
			e.printStackTrace();
		}
    }
    
    @FXML
    void btnLimparFuncionario() {
    	if (exibiDialogoConfirmacao("Todos os campos serão LIMPOS. Confirmar?")) {
    		txtNomeFuncionario.clear();
			txtCpfFuncionario.clear();
			txtCargoFuncionario.clear();
			txtSalarioFuncionario.clear();
    	}
    }
    //CONSULTAR ///////////////////////////////////////////////////////////////////
    @FXML
    void btnFuncionarioAtualizar() {
    	funcSelecionado = tabelaFuncionario.getSelectionModel().getSelectedItem();
    	if (tabelaFuncionario.getSelectionModel().getSelectedItem()== null) {
			exibiDialogoERRO("Não há funcionario selecionado!");

    	} else {
    		atualizarFuncionario.setDisable(false);
    		txtNomeFuncionarioEditar.setText(funcSelecionado.getNomefunc());
    		txtCpfFuncionarioEditar.setText(funcSelecionado.getCpffunc());
    		txtCargoFuncionarioEditar.setText(funcSelecionado.getCargo());
    		txtSalarioFuncionarioEditar.setText(funcSelecionado.getSalario());
    	}
    }

    @FXML
    void btnFuncionarioConsultar() {
    	try {
    		List<FuncionarioDTO> resultado =  funcDao.consultar(txtFuncionarioConsultar.getText());
        	if(resultado.isEmpty()) {
        		exibiDialogoINFO("Nenhum funcionario encontrado!");
        	}else {
        		tabelaFuncionario.setItems(FXCollections.observableArrayList(resultado));
        	}
		} catch (Exception e) {
			exibiDialogoERRO("Falha ao realizar a consulta!");
			e.printStackTrace();
		}
    }

    @FXML
    void btnFuncionarioDeletar() {
    	if (tabelaFuncionario.getSelectionModel().getSelectedItem()== null) {
			exibiDialogoERRO("Não há funcionario selecionado!");
    	} else {
    		
    		if (exibiDialogoConfirmacao("Confirmar a exclusão do funcionario selecionado?")) {
    	  
    			try{
					funcDao.deletarFuncionario(tabelaFuncionario.getSelectionModel().getSelectedItem().getId_funcionario());;
					exibiDialogoINFO("Funcionario deletado com sucesso!");
					txtFuncionarioConsultar.clear();
					btnFuncionarioConsultar();
    				}catch (Exception e) {
    			     exibiDialogoERRO("Falha ao deletar funcionario!");
    				}
    			}
    
    	}
    }
    //EDITAR ///////////////////////////////////////////////////////////////////
    @FXML
    void btnFuncionarioLimparAtt() {
    	if (exibiDialogoConfirmacao("Todos os campos serão LIMPOS. Confirmar?")) {
    		txtNomeFuncionarioEditar.clear();
    		txtCpfFuncionarioEditar.clear();
	    	txtCargoFuncionarioEditar.clear();
	    	txtSalarioFuncionarioEditar.clear();
    	}
    }

    @FXML
    void btnFuncionarioSalvarAtt() {
    	funcSelecionado = tabelaFuncionario.getSelectionModel().getSelectedItem();
		
		funcSelecionado.setNomefunc(txtNomeFuncionarioEditar.getText());
		funcSelecionado.setCpffunc(txtCpfFuncionarioEditar.getText());
		funcSelecionado.setCargo(txtCargoFuncionarioEditar.getText());
		funcSelecionado.setSalario(txtSalarioFuncionarioEditar.getText());
	    try {
			funcDao.atualizarFuncionario(funcSelecionado);
			exibiDialogoINFO("Funcionario atualizado com sucesso!");
			abas.getSelectionModel().select(consultar);
			btnFuncionarioConsultar();
			atualizarFuncionario.setDisable(true);
		} catch (Exception e) { 			
			exibiDialogoERRO("Falha ao atualizar funcionario!");
		}
    }

    

    @FXML
    void gerenciarAbas(MouseEvent event) {
    	if(consultar.isSelected()) {
    		atualizarFuncionario.setDisable(true);
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
