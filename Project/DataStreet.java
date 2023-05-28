package Project;


public class DataStreet {



    String street;
	int pollutionthreshold;
	int temperaturethreshold;
	int carthreshold;
    int id;
    String code;

    
    public DataStreet(String street, int pollutionthreshold, int temperaturethreshold,int carthreshold, int id, String code)
    {
        this.street = street;
        this.id = id;
        this.pollutionthreshold = pollutionthreshold;
        this.temperaturethreshold = temperaturethreshold;
        this.carthreshold= carthreshold;
        this.code = code;

    }
    public DataStreet(String street, String code)
    {
    	 this.street = street;
    	 this.code = code;
    	
    	
    }

    public String getStreet()
    {
        return street;
    }
    
    public  int getId()
    {
        return id;
    }
    public int getPollutionThreshold()
    {
        return pollutionthreshold;
    }
    public int getTemperaturethreshold()
    {
        return temperaturethreshold;
    }
    public int getCarThreshold()
    {
        return carthreshold;
    }
    
    public void setStreet(String street)
    {
        this.street =  street;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setPollutionThreshold(int pollutionthreshold)
    {
        this.pollutionthreshold = pollutionthreshold;
        
    }
    
    public void setTemperaturethreshold(int temperaturethreshold)
    {
        this.temperaturethreshold = temperaturethreshold;
    }
    
    public void setCarThreshold(int carthreshold)
    {
        this.carthreshold = carthreshold;
    }
}
