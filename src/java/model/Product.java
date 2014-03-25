/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Anthony, Etienne, Timothée
 */
public class Product {
    
    private int id;
    private String name;
    private String description;
    private float price;
    private String maker;
    private String weight;
    private int categoryId;
    
    public Product(){
        this.id = 0;
        this.name = null;
        this.description = null;
        this.price = 0;
        this.maker = null;
        this.weight = null;
        this.categoryId = 0;
    }
    
    public Product(int id, String name, String description, float price, String maker, String weight, int categoryId){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.maker = maker;
        this.weight = weight;
        this.categoryId = categoryId;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the maker
     */
    public String getMaker() {
        return maker;
    }

    /**
     * @param maker the maker to set
     */
    public void setMaker(String maker) {
        this.maker = maker;
    }

    /**
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
    @Override
    public boolean equals(Object product){
        if(product == this)
            return true;
        if(product instanceof Product){
            if(((Product)product).id == this.id){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Rédéfinition du hashCode selon developpez.com.
     * Permet de garder la cohérence entre deux objets identique
     * et une HashMap
     * @return result 
     */
    @Override
    public int hashCode(){
        int result=7;
        final int multiplier = 17;
        
        result = multiplier*result+this.id;       
        return result;
    }
}
