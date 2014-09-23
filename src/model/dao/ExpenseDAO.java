package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.beans.Campaign;
import model.beans.Expense;
import model.beans.Position;
import model.beans.Supplier;
import parse.ParseDAO;

public class ExpenseDAO extends BasicDAO<Expense> implements ParseDAO<Expense> {
	
	/*
	 * Class for manipulating the data about expenses
	 */
	
	// Constants
	private static final String DATABASE_EXPENSE_TABLE_NAME = "despesa";
	private final String DATABASE_EXPENSE_IDENTIFIER = "id_despesa";
	private final String DATABASE_EXPENSE_CAMPAIGN_YEAR = "campanha_ano";
	private final String DATABASE_EXPENSE_CAMPAIGN_CANDIDATE_NUMBER = "campanha_numero_candidato";
	private final String DATABASE_EXPENSE_VALUE = "valor";
	private final String DATABASE_EXPENSE_PAYMENT_TYPE = "forma_pagamento";
	private final String DATABASE_EXPENSE_DESCRIPTION = "descricao";
	private final String DATABASE_EXPENSE_DATE = "data_despesa";	
	private final String DATABASE_EXPENSE_TYPE = "tipo_movimentacao";
	private final String DATABASE_EXPENSE_DOCUMENT_TYPE = "tipo_documento";
	private final String DATABASE_EXPENSE_DOCUMENT_NUMBER = "numero_documento";
	private final String DATABASE_EXPENSE_SUPPLIER_NAME = "fornecedor_nome";
	private final String DATABASE_EXPENSE_SUPPLIER_PERSON_REGISTER = "fornecedor_cpf_cnpj";
	private final String DATABASE_EXPENSE_CAMPAIGN_POSITION = "cargo";
	private final String DATABASE_EXPENSE_CAMPAIGN_COUNTRY_STATE = "campanha_uf";
	
	private final String DATABASE_SQL_COMMAND_SELECT = "SELECT * FROM " + DATABASE_EXPENSE_TABLE_NAME;
	private final String DATABASE_SQL_COMMAND_INSERT = "INSERT INTO "
					   + DATABASE_EXPENSE_TABLE_NAME + " (" + DATABASE_EXPENSE_IDENTIFIER + ", " + DATABASE_EXPENSE_CAMPAIGN_YEAR + ", "
					   + DATABASE_EXPENSE_CAMPAIGN_CANDIDATE_NUMBER + ", " + DATABASE_EXPENSE_VALUE + ", " 
					   + DATABASE_EXPENSE_PAYMENT_TYPE + ", " + DATABASE_EXPENSE_DESCRIPTION + ", " + DATABASE_EXPENSE_DATE
					   + ", " + DATABASE_EXPENSE_TYPE + ", " + DATABASE_EXPENSE_DOCUMENT_TYPE 
					   + ", " + DATABASE_EXPENSE_DOCUMENT_NUMBER + ", " 
					   + DATABASE_EXPENSE_SUPPLIER_NAME + ", " + DATABASE_EXPENSE_SUPPLIER_PERSON_REGISTER + ", " 
					   + DATABASE_EXPENSE_CAMPAIGN_POSITION + ", " + DATABASE_EXPENSE_CAMPAIGN_COUNTRY_STATE
					   + ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	

	// Constructors
	public ExpenseDAO() {
		super(DATABASE_EXPENSE_TABLE_NAME, null);
	}

	// Other methods
	/*
	 * This method retrieves the SQL command to insert data
	 * @return a String with the SQL command
	 */
	@Override
	protected String getSQLInsertCommand() {
		return DATABASE_SQL_COMMAND_INSERT;
	}

	/*
	 * This method retrieves the string that has the SQL command for selecting data in a database table
	 * @return a String with the SQL command
	 */
	@Override
	protected String getSQLSelectCommand() {
		return DATABASE_SQL_COMMAND_SELECT;
	}

	/*
	 * This method prepares a list of expenses to be registered
	 * @param an ArrayList<Expense>
	 * @param a SQLinstruction
	 */
	@Override
	protected void registerObjectArrayListOnBatch(ArrayList<Expense> expenseList,
			PreparedStatement daoSQLInstruction) throws SQLException {
		for(Expense expense : expenseList) {
			daoSQLInstruction.setInt(1, expense.getFinancialTransactionIdentifier());	
			daoSQLInstruction.setInt(2, expense.getFinancialTransactionCampaign().getCampaignYear());
			daoSQLInstruction.setInt(3, expense.getFinancialTransactionCampaign().getCampaignCandidateNumber());
			daoSQLInstruction.setFloat(4, expense.getFinancialTransactionPrice());	
			daoSQLInstruction.setString(5, expense.getFinancialTransactionPaymentType());
			daoSQLInstruction.setString(6, expense.getFinancialTransactionDescription());
			daoSQLInstruction.setString(7, expense.getFinancialTransactionDate());	
			daoSQLInstruction.setString(8, expense.getFinancialTransactionType());
			daoSQLInstruction.setString(9, expense.getExpenseDocumentType());
			daoSQLInstruction.setString(10, expense.getFinancialTransactionDocumentNumber());
			daoSQLInstruction.setString(11, expense.getExpenseSupplier().getSupplierName());
			daoSQLInstruction.setString(12, expense.getExpenseSupplier().getSupplierPersonRegister());
			daoSQLInstruction.setString(13, expense.getFinancialTransactionCampaign().getCampaignPosition().getPositionDescription());
			daoSQLInstruction.setString(14, expense.getFinancialTransactionCampaign().getCampaignCountryState());
			daoSQLInstruction.addBatch();
		}
	}

	/*
	 * This method populates the ArrayList<Expense>
	 * @param an ArrayList<Expense>
	 * @param a SQLresult
	 */
	@Override
	protected void registerResultSetOnObjectArrayList(ArrayList<Expense> expenseList,
			ResultSet sqlResult) throws SQLException {
		while(sqlResult.next()) {
			Campaign campaign = new Campaign();
			Position position = new Position();
			position.setPositionDescription(sqlResult.getString(DATABASE_EXPENSE_CAMPAIGN_POSITION));
			campaign.setCampaignYear(sqlResult.getInt(DATABASE_EXPENSE_CAMPAIGN_YEAR));
			campaign.setCampaignCandidateNumber(sqlResult.getInt(DATABASE_EXPENSE_CAMPAIGN_CANDIDATE_NUMBER));
			campaign.setCampaignCountryState(sqlResult.getString(DATABASE_EXPENSE_CAMPAIGN_COUNTRY_STATE));
			campaign.setCampaignPosition(position);

			Supplier supplier = new Supplier();
			supplier.setSupplierPersonRegister(sqlResult.getString(DATABASE_EXPENSE_SUPPLIER_PERSON_REGISTER));
			supplier.setSupplierName(sqlResult.getString(DATABASE_EXPENSE_SUPPLIER_NAME));

			Expense expense = new Expense();
			expense.setFinancialTransactionIdentifier(sqlResult.getInt(DATABASE_EXPENSE_IDENTIFIER));			
			expense.setFinancialTransactionCampaign(campaign);
			expense.setFinancialTransactionDate(sqlResult.getString(DATABASE_EXPENSE_DATE));
			expense.setFinancialTransactionDescription(sqlResult.getString(DATABASE_EXPENSE_DESCRIPTION));
			expense.setFinancialTransactionPaymentType(sqlResult.getString(DATABASE_EXPENSE_PAYMENT_TYPE));
			expense.setExpenseSupplier(supplier);
			expense.setFinancialTransactionDocumentNumber(sqlResult.getString(DATABASE_EXPENSE_DOCUMENT_NUMBER));
			expense.setExpenseDocumentType(sqlResult.getString(DATABASE_EXPENSE_DOCUMENT_TYPE));
			expense.setFinancialTransactionType(sqlResult.getString(DATABASE_EXPENSE_TYPE));
			expense.setFinancialTransactionPrice(sqlResult.getFloat(DATABASE_EXPENSE_VALUE));
			
			expenseList.add(expense);
		}
	}

	/*
	 * This method retrieves a list of expenses through the year, candidate number,
	 * position and unit federation
	 * @param an instance of Class Campaign
	 * @return an ArrayList<Expense>
	 */
	public ArrayList<Expense> getExpenseByCampaignYearAndCandidateNumberAndCampaignCountryStateAndCampaignPosition(Campaign campaign) throws Exception {
		String sqlCommand = DATABASE_SQL_COMMAND_SELECT + " WHERE "
				  + DATABASE_EXPENSE_CAMPAIGN_YEAR + " = " + campaign.getCampaignYear() + " AND "
				  + DATABASE_EXPENSE_CAMPAIGN_CANDIDATE_NUMBER + " = " + campaign.getCampaignCandidateNumber()
				  + " AND " + DATABASE_EXPENSE_CAMPAIGN_COUNTRY_STATE + " = '" + campaign.getCampaignCountryState()
				  + "' AND " + DATABASE_EXPENSE_CAMPAIGN_POSITION 
				  + " LIKE '%" + campaign.getCampaignPosition().getPositionDescription()
				  + "%'";
		return searchExpenseInDatabaseUsingSQLCommandConfiguredBefore(sqlCommand);
	}
	
	/*
	 * This method retrieves an instance of Class Expense through DATABASE_EXPENSE_IDENTIFIER
	 * @param an int value with the DATABASE_EXPENSE_IDENTIFIER
	 * @return an instance of Class Expense
	 */
	public Expense getExpenseByIdentifier(int expenseIdentifier) throws Exception {
			String sqlCommand = DATABASE_SQL_COMMAND_SELECT + " WHERE "
					  + DATABASE_EXPENSE_IDENTIFIER + " = " + expenseIdentifier;
			return searchExpenseInDatabaseUsingSQLCommandConfiguredBefore(sqlCommand).get(0);
	}
	
	/*
	 * This method retrieves a complete list of Expenses stored in the database
	 * @param a String with the SQL command
	 * @return an ArrayList<Expense>
	 */
	public ArrayList<Expense> searchExpenseInDatabaseUsingSQLCommandConfiguredBefore(String sqlCommandConfiguredBefore) throws Exception {
		ArrayList<Expense> expenseList = new ArrayList<>();

		try {
			this.connection = new DatabaseConnection().getConnection();

			String sqlCommand = sqlCommandConfiguredBefore;

			this.daoSQLInstruction = this.connection.prepareStatement(sqlCommand);

			ResultSet sqlResult = (ResultSet) daoSQLInstruction.executeQuery();

			while(sqlResult.next()) {
				Expense expense = new Expense();
				Position position = new Position();
				position.setPositionDescription(sqlResult.getString(DATABASE_EXPENSE_CAMPAIGN_POSITION));

				Campaign campaign = new Campaign();
				campaign.setCampaignYear(sqlResult.getInt(DATABASE_EXPENSE_CAMPAIGN_YEAR));
				campaign.setCampaignCandidateNumber(sqlResult.getInt(DATABASE_EXPENSE_CAMPAIGN_CANDIDATE_NUMBER));
				campaign.setCampaignPosition(position);
				expense.setFinancialTransactionCampaign(campaign);
				
				Supplier supplier = new Supplier();
				supplier.setSupplierName(sqlResult.getString(DATABASE_EXPENSE_SUPPLIER_NAME));
				supplier.setSupplierPersonRegister(sqlResult.getString(DATABASE_EXPENSE_SUPPLIER_PERSON_REGISTER));
				expense.setExpenseSupplier(supplier);

				expense.setFinancialTransactionDate(sqlResult.getString(DATABASE_EXPENSE_DATE));
				expense.setFinancialTransactionDescription(sqlResult.getString(DATABASE_EXPENSE_DESCRIPTION));
				expense.setFinancialTransactionPaymentType(sqlResult.getString(DATABASE_EXPENSE_PAYMENT_TYPE));
				expense.setFinancialTransactionIdentifier(sqlResult.getInt(DATABASE_EXPENSE_IDENTIFIER));
				expense.setFinancialTransactionDocumentNumber(sqlResult.getString(DATABASE_EXPENSE_DOCUMENT_NUMBER));
				expense.setExpenseDocumentType(sqlResult.getString(DATABASE_EXPENSE_DOCUMENT_TYPE));
				expense.setFinancialTransactionType(sqlResult.getString(DATABASE_EXPENSE_TYPE));
				expense.setFinancialTransactionPrice(sqlResult.getFloat(DATABASE_EXPENSE_VALUE));
				
				if(expense != null) {
					expenseList.add(expense);
				}
			}

		}  catch(SQLException e) {
			throw new SQLException("ExpenseDAO - " + e.getMessage());
		} finally {
			closeDatabaseConnection();
		}
		return expenseList;
	}
}