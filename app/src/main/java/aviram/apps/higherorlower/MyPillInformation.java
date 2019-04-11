package aviram.apps.higherorlower;

import org.json.JSONException;
import org.json.JSONObject;

public class MyPillInformation
{
    private String pillId = "";
    private String pillName = "";
    private String pillDescription = "";
    private String pillDosage = "";
    private String pillElegranIngredients = "";
    private String pillPregnancySafe = "";
    private String pillurl = "";


    //----------------------------------Setters----------------------------------------------------

    public void setPillIformation( JSONObject i_detailsObj) throws JSONException {
        setName(i_detailsObj.getString("name"));
        setDescription(i_detailsObj.getString("description"));
        setElegranIngredients(i_detailsObj.getString("elegranIngredients"));
        setUrl(i_detailsObj.getString("url"));
        setId(i_detailsObj.getString("id"));
        setDosAge(i_detailsObj.getString("dosage"));
        setPregnancySafe(i_detailsObj.getBoolean("pregnancySafe"));
    }

    public void setName(String name)
    {
        this.pillName = name;
    }

    public void setDescription(String description)
    {
        this.pillDescription = description;
    }
    public void setElegranIngredients(String elegranIngredients)
    {
        this.pillElegranIngredients = elegranIngredients;
    }
    public void setUrl(String url)
    {
        this.pillurl = url;
    }
    public void setId(String id)
    {
        this.pillId = id;
    }
    public void setDosAge(String dosAge)
    {
        this.pillDosage = dosAge;
    }
    public void setPregnancySafe(boolean pregnancySafe)
    {
        if(pregnancySafe) {
            this.pillPregnancySafe = "Safe";
        }
        else
        {
            this.pillPregnancySafe = "Not Safe";
        }
    }

    //----------------------------------Getters---------------------------------------------

    public String getName()
    {
        return pillName;
    }
    public String getDescription()
    {
        return pillDescription;
    }
    public String getElegranIngredients()
    {
        return pillElegranIngredients;
    }
    public String getUrl()
    {
        return pillurl;
    }
    public String getId()
    {
        return pillId;
    }
    public String getDosAge()
    {
        return pillDosage;
    }
    public String getPregnancySafe()
    {
        return pillPregnancySafe;
    }
}
