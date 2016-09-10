package industries.mav.localbuddy;

/**
 * Created by vincekearney on 10/09/2016.
 */
public class Tweets
{
    private String name;
    private String body;
    private String imageName;

    public Tweets(String name, String body, String imageName) {
        this.name = name;
        this.body = body;
        this.imageName = imageName;
    }

    public String getBody() {
        return body;
    }

    public String getImageName() {
        return imageName;
    }

    public String getName() {
        return name;
    }
}
