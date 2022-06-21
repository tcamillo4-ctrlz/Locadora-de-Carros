package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

	ConnectionFactory conn = new ConnectionFactory();
	PreparedStatement stm;
	
	//CADASTRAR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void cadastrarCliente(ClienteDTO objcarroDTO){
		String sql = "INSERT INTO ClienteLoc (nomecli, cpfcli, telefonecli, totalcli) VALUES (?,?,?,?)";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){

			stm.setString(1, objcarroDTO.getNomecli());
			stm.setString(2, objcarroDTO.getCpfcli());
			stm.setString(3, objcarroDTO.getTelefonecli());
			stm.setString(4, objcarroDTO.getTotalcli());
			
			stm.execute();	
			stm.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	}
	//CONSULTAR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<ClienteDTO> consultar(String cpfcli) {
		
		List<ClienteDTO> clientes = new ArrayList<>();
		
		String sql = "SELECT * FROM ClienteLoc WHERE cpfcli LIKE '%" + cpfcli + "%'";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			ResultSet resultSet = stm.executeQuery();
			while (resultSet.next()){
			
				ClienteDTO objClienteDTO = new ClienteDTO();
				
				objClienteDTO.setId_cliente(resultSet.getInt("id_cliente"));
				objClienteDTO.setNomecli(resultSet.getString("nomecli"));
				objClienteDTO.setCpfcli(resultSet.getString("cpfcli"));
				objClienteDTO.setTelefonecli(resultSet.getString("telefonecli"));
				objClienteDTO.setTotalcli(resultSet.getString("totalcli"));
				clientes.add(objClienteDTO);
			}
			
			resultSet.close();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return clientes;
	}
	//DELETAR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void deletarCliente(Integer id_cliente) {
		String sql = "DELETE FROM ClienteLoc WHERE id_cliente = ?";
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setInt(1, id_cliente);
			
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	//ATUALIZAR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void atualizarCliente(ClienteDTO objClienteDTO) {
		String sql = "UPDATE ClienteLoc SET nomecli = ?, cpfcli = ?, telefonecli = ?, totalcli = ? WHERE id_cliente = ?";
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setString(1, objClienteDTO.getNomecli());
			stm.setString(2, objClienteDTO.getCpfcli());
			stm.setString(3, objClienteDTO.getTelefonecli());
			stm.setString(4, objClienteDTO.getTotalcli());
			stm.setInt(5, objClienteDTO.getId_cliente());

			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
}
