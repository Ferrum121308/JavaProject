package Experiment4.FruitDao;

import Experiment4.Fruit.FruitEntity;

import java.util.ArrayList;

public class FruitDao {
    ArrayList<FruitEntity> list = new ArrayList<>();
    public ArrayList getList(){
        return list;
    }
    public void setList(){
        this.list = list;
    }
    public FruitDao(){
        super();
        FruitEntity fruit1 = new FruitEntity("苹果",1,5.0,"kg");
        list.add(fruit1);
        FruitEntity fruit2 = new FruitEntity("香蕉",2,25.3,"kg");
        list.add(fruit2);
        FruitEntity fruit3 = new FruitEntity("哈密瓜",3,8.9,"kg");
        list.add(fruit3);
    }
    public void addFruit(FruitEntity fruit){
        list.add(fruit);
    }
    public void updateFruit(int id,FruitEntity fruit){
        list.set(id,fruit);
    }
    public void deleteFruit(int id){
        list.remove(id);
    }
    public boolean isExist(int id){
        if(list.contains(id)){
            return true;
        }
        return false;
    }
}
