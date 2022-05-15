package mediaplayer.builder;

public class Actions { //Builder class
    private String name;
    private String type;
    private String description;
    private String image;
    private String action;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public static class Builder{
        private final Actions newAction;

        public Builder(){

            newAction = new Actions();
        }

        public Builder setName(String name){
            newAction.setName(name);
            return this;
        }

        public Builder setType(String type){
            newAction.setType(type);
            return this;
        }

        public Builder setDescription(String description){
            newAction.setDescription(description);
            return this;
        }

        public Builder setImage(String image){
            newAction.setImage(image);
            return this;
        }

        public Builder setAction(String action){
            newAction.setAction(action);
            return this;
        }

        public Actions build(){
            return newAction;
        }
    }
}
