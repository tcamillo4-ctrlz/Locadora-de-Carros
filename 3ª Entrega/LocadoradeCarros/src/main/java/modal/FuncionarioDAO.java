package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

	ConnectionFactory conn = new ConnectionFactory();
	PreparedStatement stm;
	
	//CADASTRAR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void cadastrarFuncionario(FuncionarioDTO objcarroDTO){
		String sql = "INSERT INTO FuncionarioLoc (nomefunc, cpffunc, cargo, salario) VALUES (?,?,?,?)";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){

			stm.setString(1, objcarroDTO.getNomefunc());
			stm.setString(2, objcarroDTO.getCpffunc());
			stm.setString(3, objcarroDTO.getCargo());
			stm.setString(4, objcarroDTO.getSalario());
			
			stm.execute();	
			stm.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	}
	//CONSULTAR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<FuncionarioDTO> consultar(String cpffunc) {
		
		List<FuncionarioDTO> funcs = new ArrayList<>();
		
		String sql = "SELECT * FROM FuncionarioLoc WHERE cpffunc LIKE '%" + cpffunc + "%'";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			ResultSet resultSet = stm.executeQuery();
			while (resultSet.next()){
			
				FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();
				
				objFuncionarioDTO.setId_funcionario(resultSet.getInt("id_funcionario"));
				objFuncionarioDTO.setNomefunc(resultSet.getString("nomefunc"));
				objFuncionarioDTO.setCpffunc(resultSet.getString("cpffunc"));
				objFuncionarioDTO.setCargo(resultSet.getString("cargo"));
				objFuncionarioDTO.setSalario(resultSet.getString("salario"));
				funcs.add(objFuncionarioDTO);
			}
			
			resultSet.close();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return funcs;
	}
	//DELETAR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void deletarFuncionario(Integer id_funcionario) {
		String sql = "DELETE FROM FuncionarioLoc WHERE id_funcionario = ?";
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setInt(1, id_funcionario);
			
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	//ATUALIZAR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void atualizarFuncionario(FuncionarioDTO objFuncionarioDTO) {
		String sql = "UPDATE FuncionarioLoc SET nomefunc = ?, cpffunc = ?, cargo = ?, salario = ? WHERE id_funcionario = ?";
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setString(1, objFuncionarioDTO.getNomefunc());
			stm.setString(2, objFuncionarioDTO.getCpffunc());
			stm.setString(3, objFuncionarioDTO.getCargo());
			stm.setString(4, objFuncionarioDTO.getSalario());
			stm.setInt(5, objFuncionarioDTO.getId_funcionario());

			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
}
