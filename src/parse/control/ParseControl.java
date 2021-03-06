package parse.control;

import java.util.ArrayList;

import parse.ParseDAO;
import parse.ParseException;
import parse.index.ParseIndex;

public abstract class ParseControl<O> {
	
	/*
	 * Abstract class for template methods to be used by subclasses to parse control
	 */

	// Attributes
	
	// Variable that represent a empty object generic
	private O emptyObject;
	
	// Variable that represent a instance of basicDAO for register the objects was worked in database
	private ParseDAO<O> basicDAO;
	
	// Variable that represent a instance generic parse's index for register of indices generated file
	private ParseIndex<O> indexParse;
	
	// Variable that represent a instance generic of a instance's list for register of instances generate
	protected ArrayList<O> listInstance;
	
	// Constructors
	public ParseControl(ParseIndex<O> indexParse, ParseDAO<O> basicDAO) {
		this.listInstance = new ArrayList<>();

		this.basicDAO = basicDAO;
		this.indexParse = indexParse;
		this.emptyObject = newInstance();
	}

	// Method signature to make a new instance of an object of any class
	public abstract O newInstance();
	
	// Signature of the method to compare two objects of any class
	public abstract boolean equalObjects(O objectOne, O objectTwo);
	
	/*
	 * This method adds an instance of a class in the list of instances
	 * @param an array of strings
	 */
	public void addInstance(String field[]) {
		O object = makeNewInstance(field);
		
		// Variable that represent a condition for object provided be registered in the list of instances 
		boolean noEmptyObjectAndNoContainsObjectInListInstance = (!equalObjects(object, emptyObject))
				&& (!this.listInstance.contains(object));
		
		if(noEmptyObjectAndNoContainsObjectInListInstance) {
			this.listInstance.add(object);
		}
	}

	/*
	 * This method performs addition of instances without performing validation of existence 
	 * in the list of instances
	 * @param an array of strings
	 */
	public void addEqualInstance(String field[]) {
		O object = makeNewInstance(field);
		
		// Variable that represent a condition for object provided be registered in the list of instances 
		boolean noEmptyObject = (!equalObjects(object, emptyObject));
		
		if(noEmptyObject) {
			this.listInstance.add(object);
		}
	}
	
	/*
	 * This method formalizes the registration of a list of instances
	 */
	public void registeringInstances() throws ParseException {
		this.basicDAO.registerObjectArrayListOnParse(this.listInstance);
	}
	
	/*
	 * This method performs a cleaning at the array of instances to register
	 */
	public void clear() {
		this.listInstance.clear();
	}
	
	/*
	 * This method makes a new instance and returns the instantiated object
	 * @param an array of strings
	 * @return an object of any class
	 */
	private O makeNewInstance(String field[]) {
		O object = newInstance();
		this.indexParse.startInstance(object, field);
		return object;
	}
}