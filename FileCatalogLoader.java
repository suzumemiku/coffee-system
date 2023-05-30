package Experiment1;

import java.io.*;
import java.util.ArrayList;

public class FileCatalogLoader implements CatalogLoader{
    @Override
    public Catalog loadCatalog(String fileName) throws FileNotFoundException, IOException, DataFormatException {
        File file=new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        ArrayList<String> str=new ArrayList<>();
        while(line!=null)
        {
            str.add(line);
            line=br.readLine();
        }
        Catalog catalog=new Catalog();
        for(String s:str)
            if(s.startsWith("Product_"))
                catalog.addProduct(readProduct(s));
            else if(s.startsWith("Coffee_"))
                catalog.addProduct(readCoffee(s));
            else if(s.startsWith("CoffeeBrewer_"))
                catalog.addProduct(readCoffeeBrewer(s));
        return catalog;
    }

    private Product readProduct(String line) throws DataFormatException{
        String[] strings=line.split("_");
        try{
            double d=Double.parseDouble(strings[3]);
            if(strings.length!=4)
                throw new DataFormatException("长度错误");
            Product product=new Product(strings[1],strings[2],d);
            return  product;
        }
        catch (NumberFormatException e){
            throw new DataFormatException("类型错误");
        }
        catch (DataFormatException E){
            return  null;
        }
    }
    private Coffee readCoffee(String line) throws DataFormatException{
        String[] strings=line.split("_");
        try{
            double d=Double.parseDouble(strings[3]);
            if(strings.length!=10)
                throw new DataFormatException("长度错误");
            Coffee coffee=new Coffee(strings[1],strings[2],d,strings[4],strings[5],strings[6],strings[7],strings[8],strings[9]);
            return  coffee;
        }
        catch (NumberFormatException e){
            throw new DataFormatException("类型错误");
        }
        catch (DataFormatException E){
            return  null;
        }
    }
    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException{
        String[] strings=line.split("_");
        try{
            double d=Double.parseDouble(strings[3]);
            int i= Integer.parseInt(strings[6]);
            if(strings.length!=7)
                throw new DataFormatException("长度错误");
            CoffeeBrewer coffeeBrewer=new CoffeeBrewer(strings[1],strings[2],d,strings[4],strings[5],i);
            return  coffeeBrewer;
        }
        catch (NumberFormatException e){
            throw new DataFormatException("类型错误");
        }
        catch (DataFormatException E){
            return  null;
        }
    }

}