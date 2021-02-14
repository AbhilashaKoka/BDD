package cucumber;
import java.util.HashMap;
import java.util.Map;
import enums.Context;
import enums.DocumentType;

//Scenario Context class holds the test data information explicitly. 
//It helps you store values in a key-value pair between the steps. Moreover, 
//it helps in organizing step definitions better rather than using private variables in step definition classes
public class ScenarioContext {
	 
	private  Map<String, Object> scenarioContext;

	    public ScenarioContext()
	    {
	    scenarioContext = new HashMap<>();
	    }
	    public void setContext(Context key, Object value)
	    {
	    scenarioContext.put(key.toString(), value);
	    }
	    public Object getContext(Context key)
	    {
	     return scenarioContext.get(key.toString());
	    }
	    public Boolean isContains(Context key)
	    {
	    return scenarioContext.containsKey(key.toString());
	    }
	    public void setContext(DocumentType key, Object value)
	    {
	    scenarioContext.put(key.toString(), value);
	    }
	    public Object getContext(DocumentType key)
	    {
	     return scenarioContext.get(key.toString());
	    }
	    public Boolean isContains(DocumentType key)
	    {
	    return scenarioContext.containsKey(key.toString());
	    }
	    
	    

	    
}