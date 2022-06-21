package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {

	ConnectionFactory conn = new ConnectionFactory();
	PreparedStatement stm;
	
	//CADASTRAR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void cadastrarCarro(CarroDTO objcarroDTO){
		String sql = "INSERT INTO CarroLoc (placa, modelo, marca, preco) VALUES (?,?,?,?)";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){

			stm.setString(1, objcarroDTO.getPlaca());
			stm.setString(2, objcarroDTO.getModelo());
			stm.setString(3, objcarroDTO.getMarca());
			stm.setString(4, objcarroDTO.getPreco());
			
			stm.execute();	
			stm.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	}
	//CONSULTAR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<CarroDTO> consultar(String placa) {
		
		List<CarroDTO> carros = new ArrayList<>();
		
		String sql = "SELECT * FROM CarroLoc WHERE placa LIKE '%" + placa + "%'";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			ResultSet resultSet = stm.executeQuery();
			while (resultSet.next()){
			
				CarroDTO objCarroDTO = new CarroDTO();
				
				objCarroDTO.setId_carro(resultSet.getInt("id_carro"));
				objCarroDTO.setPlaca(resultSet.getString("placa"));
				objCarroDTO.setModelo(resultSet.getString("modelo"));
				objCarroDTO.setMarca(resultSet.getString("marca"));
				objCarroDTO.setPreco(resultSet.getString("preco"));
				carros.add(objCarroDTO);
			}
			
			resultSet.close();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return carros;
	}
	//DELETAR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void deletarCarro(Integer id_carro) {
		String sql = "DELETE FROM CarroLoc WHERE id_carro = ?";
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setInt(1, id_carro);
			
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	//ATUALIZAR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void atualizarCarro(CarroDTO objCarroDTO) {
		String sql = "UPDATE CarroLoc SET placa = ?, modelo= ?, marca = ?, preco = ? WHERE id_carro = ?";
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setString(1, objCarroDTO.getPlaca());
			stm.setString(2, objCarroDTO.getModelo());
			stm.setString(3, objCarroDTO.getMarca());
			stm.setString(4, objCarroDTO.getPreco());
			stm.setInt(5, objCarroDTO.getId_carro());

			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
}
