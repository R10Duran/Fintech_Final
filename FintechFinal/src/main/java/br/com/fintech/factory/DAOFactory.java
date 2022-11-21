package br.com.fintech.factory;

import br.com.fintech.dao.*;
import br.com.fintech.dao.impl.*;

public class DAOFactory {
	
	public static ReceitaDAO getReceitaDAO() {
		return new OracleReceitaDAO();
	}
	
}
