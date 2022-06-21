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
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modal.CarroDAO;
import modal.CarroDTO;

public class CarroController implements Initializable {

    @FXML
    private TabPane abas;

    @FXML
    private Tab atualizarCarro;
    
    @FXML
    private TableView<CarroDTO> tabelaCarro;
    
    @FXML
    private TableColumn<CarroDTO, Integer> colCarroId;
    
    @FXML
    private TableColumn<CarroDTO, String> colCarroPlaca;
    
    @FXML
    private TableColumn<CarroDTO, String> colCarroModelo;

    @FXML
    private TableColumn<CarroDTO, String> colCarroMarca;

    @FXML
    private TableColumn<CarroDTO, String> colCarroPreco;

    @FXML
    private Tab consultar;

    @FXML
    private Tab consultar1;

    @FXML
    private Label lblPlaca;

    @FXML
    private TextField txtAno;

    @FXML
    private TextField txtAnoEditar;

    @FXML
    private TextField txtCor;

    @FXML
    private TextField txtCorEditar;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtMarcaEditar;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtModeloEditar;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtPlacaEditar;

    @FXML
    private TextField txtPreco;

    @FXML
    private TextField txtPrecoEditar;

    @FXML
    private TextField txtCarroConsultar;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
		carroDao = new CarroDAO();
		
		colCarroId.setCellValueFactory(new PropertyValueFactory<>("id_carro"));
		colCarroPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
		colCarroModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		colCarroMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
		colCarroPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
    }

    private CarroDTO carroSelecionado;
    private CarroDAO carroDao;
    //CADASTRAR ///////////////////////////////////////////////////////////////////
    @FXML
    void btnCadastrarCarro() {
    	CarroDTO carro = new CarroDTO();
    	
    	carro.setPlaca(txtPlaca.getText());
    	carro.setModelo(txtModelo.getText());
    	carro.setMarca(txtMarca.getText());
		carro.setPreco(txtPreco.getText());
		try {
			carroDao.cadastrarCarro(carro);
			exibiDialogoINFO("Carro cadastrado com sucesso!");
			txtPlaca.clear();
	    	txtModelo.clear();
	    	txtMarca.clear();
	    	txtPreco.clear();
		} catch (Exception e) {
			exibiDialogoERRO("Falha ao cadastrar carro!");
			e.printStackTrace();
		}
    }
    
    @FXML
    void btnLimparCarro() {
    	if (exibiDialogoConfirmacao("Todos os campos serão LIMPOS. Confirmar?")) {
	    	txtPlaca.clear();
	    	txtModelo.clear();
	    	txtMarca.clear();
	    	txtPreco.clear();
    	}
    }
    
    //CONSULTAR ///////////////////////////////////////////////////////////////////
    @FXML
    void btnConsultarPlaca() {
    	try {
    		List<CarroDTO> resultado =  carroDao.consultar(txtCarroConsultar.getText());
        	if(resultado.isEmpty()) {
        		exibiDialogoINFO("Nenhum carro encontrado!");
        	}else {
        		tabelaCarro.setItems(FXCollections.observableArrayList(resultado));
        	}
		} catch (Exception e) {
			exibiDialogoERRO("Falha ao realizar a consulta de carro!");
			e.printStackTrace();
		}
    }
    
    @FXML
    void btnCarroAtualizar() {
    	carroSelecionado = tabelaCarro.getSelectionModel().getSelectedItem();
    	if (tabelaCarro.getSelectionModel().getSelectedItem()== null) {
			exibiDialogoERRO("Não há carro selecionado!");

    	} else {
    		atualizarCarro.setDisable(false);
    		txtPlacaEditar.setText(carroSelecionado.getPlaca());
    		txtModeloEditar.setText(carroSelecionado.getModelo());
    		txtMarcaEditar.setText(carroSelecionado.getMarca());
    		txtPrecoEditar.setText(carroSelecionado.getPreco());
    	}
    }

    @FXML
    void btnCarroDeletar() {
    	if (tabelaCarro.getSelectionModel().getSelectedItem()== null) {
			exibiDialogoERRO("Não há carro selecionado!");
    	} else {
    		
    		if (exibiDialogoConfirmacao("Confirmar a exclusão do carro selecionado?")) {
    	  
    			try{
					carroDao.deletarCarro(tabelaCarro.getSelectionModel().getSelectedItem().getId_carro());;
					exibiDialogoINFO("Carro deletado com sucesso!");
					txtCarroConsultar.clear();
					btnConsultarPlaca();
    				}catch (Exception e) {
    			     exibiDialogoERRO("Falha ao deletar carro!");
    				}
    			}
    
    	}
    }
    //EDITAR ///////////////////////////////////////////////////////////////////
    @FXML
    void btnCarroLimparAtt() {
    	if (exibiDialogoConfirmacao("Todos os campos serão LIMPOS. Confirmar?")) {
	    	txtPlacaEditar.clear();
	    	txtModeloEditar.clear();
	    	txtMarcaEditar.clear();
	    	txtPrecoEditar.clear();
    	}
    }

    @FXML
    void btnCarroSalvarAtt() {
    	carroSelecionado = tabelaCarro.getSelectionModel().getSelectedItem();
		
		carroSelecionado.setPlaca(txtPlacaEditar.getText());
		carroSelecionado.setModelo(txtModeloEditar.getText());
		carroSelecionado.setMarca(txtMarcaEditar.getText());
		carroSelecionado.setPreco(txtPrecoEditar.getText());
	    try {
			carroDao.atualizarCarro(carroSelecionado);
			exibiDialogoINFO("Carro atualizado com sucesso!");
			abas.getSelectionModel().select(consultar);
			btnConsultarPlaca();
			atualizarCarro.setDisable(true);
		} catch (Exception e) { 			
			exibiDialogoERRO("Falha ao atualizar carro!");
		}
    }    

    @FXML
    void gerenciarAbas(MouseEvent event) {
    	if(consultar.isSelected()) {
    		atualizarCarro.setDisable(true);
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
