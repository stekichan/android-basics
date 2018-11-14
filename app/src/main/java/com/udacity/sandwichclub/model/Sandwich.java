package com.udacity.sandwichclub.model;

import android.net.Uri;

import java.util.Iterator;
import java.util.List;

public class Sandwich {

    private String mainName;
    private List<String> alsoKnownAs = null;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<String> ingredients = null;

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {
    }

    static String list_to_string(List<String> list)
    {
        Iterator it;
        String   S = "Not available";

        if (list == null)
            return S;
        if (list.isEmpty())
            return S;
         it = list.iterator();
        while (it.hasNext()) {
            if (S.equals("Not available"))
                S = (String) it.next();
            else
                S = S + ", " + it.next();
        }
        return S;
    }

    public static String null_string_process(String string)
    {
        return (string == null || string.isEmpty()) ? "Not available" : string;
    }

    public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = null_string_process(placeOfOrigin);
        this.description = null_string_process(description);
        this.image = image;
        this.ingredients = ingredients;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public String getAlsoKnownAsString()
    {
        return list_to_string(getAlsoKnownAs());
    }

    public void setAlsoKnownAs(List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Uri getImage() {
        return Uri.parse(image);
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
    public String getIngredientsString() {return list_to_string(getIngredients());}

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
