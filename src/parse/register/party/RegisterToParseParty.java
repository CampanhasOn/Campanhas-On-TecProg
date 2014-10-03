package parse.register.party;

import parse.ParseException;
import parse.control.ParseControl;
import parse.control.ParseControlParty;
import parse.index.ParseIndex;
import parse.index.PartyParseIndex;
import parse.register.RegisterParse;
import model.beans.Party;

public class RegisterToParseParty extends RegisterParse<Party> {
	
	/*
	 * Class responsible for identifying the contents of the file to read and get information
	 */

	// Constructors
	public RegisterToParseParty(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}

	/*
	 * This method formalizes the instance index to be used
	 * @param an instance of class ParseIndex<Party>
	 * @return an instance of class PartyParseControl
	 */
	@Override
	public ParseControl<Party> newIntance(
			ParseIndex<Party> indicesParse) {
		ParseControlParty parseControlParty;
		parseControlParty = new ParseControlParty(indicesParse);
		return parseControlParty;
	}

	/*
	 * This method checks the file type to correctly identify the indexes that have the information
	 * to be read and stored
	 * @param an String tipoArquivo
	 * @param an String ano
	 * @return an instance of class PartyIndicesParse
	 */
	@Override
	protected ParseIndex<Party> getParseIndex(String tipoArquivo,
			String ano) throws ParseException {
		PartyParseIndex partyParseIndex;
		partyParseIndex = new PartyParseIndex();
		if(tipoArquivo.equals("partido"))
		{
			partyParseIndex.setIndexPartyName(2);
			partyParseIndex.setIndexAcronym(1);
			partyParseIndex.setIndexNumberParty(5);
			partyParseIndex.setIndexDeferral(3);
		}else if(tipoArquivo.equals("campanha"))
		{
			partyParseIndex.setIndexPartyName(18);
			partyParseIndex.setIndexAcronym(17);
			partyParseIndex.setIndexNumberParty(16);
		}
		return partyParseIndex;
	}

}