/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

/**
 *
 * @author shorook
 */


//import com.sun.xml.internal.ws.util.StringUtils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
//import javafx.scene.paint.LinearGradient;
//import javafx.scene.paint.Stop;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
//import javafx.scene.effect.Reflection;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.StackPane;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
//import javafx.scene.text.Text;
import javafx.scene.control.Dialog;
import javafx.scene.control.IndexRange;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;

import javafx.stage.Stage;
public class Lab7 extends Application {
 MenuBar bar = new MenuBar();
       Menu file=new Menu("File");
        Menu edit =new Menu("Edit");
         Menu help =new Menu("Help");
         
        
        
       MenuItem neww= new MenuItem("New");
      // neww.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("plus.png"))));
        MenuItem open= new MenuItem("Open");
         MenuItem save= new MenuItem("Save");
          SeparatorMenuItem sep = new SeparatorMenuItem();
          SeparatorMenuItem sepp = new SeparatorMenuItem();
          SeparatorMenuItem seppp = new SeparatorMenuItem();
          
         MenuItem exit= new MenuItem("Exit");
          MenuItem undo= new MenuItem("Undo");
            MenuItem cut= new MenuItem("Cut");
              MenuItem copy= new MenuItem("Copy");
                MenuItem paste= new MenuItem("Paste");
                  MenuItem delete= new MenuItem("Delete");
                    MenuItem select = new MenuItem("Select All");
                      MenuItem about= new MenuItem("About Notepad");
                      TextArea text = new TextArea();
         
       Dialog<String> dialog = new Dialog<String>();
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Application.launch();
    }

    @Override
    public void init(){
       
    
       neww.setAccelerator(KeyCombination.keyCombination("Ctrl+n")); 
       open.setAccelerator(KeyCombination.keyCombination("Ctrl+o")); 
       exit.setAccelerator(KeyCombination.keyCombination("ESC")); 
       file.getItems().addAll(neww,open,save,exit);
       file.getItems().add(3, sep);
      
       
       edit.getItems().addAll(undo,cut,copy,paste,delete,select);
        edit.getItems().add(1, sepp);
        edit.getItems().add(6, seppp);
        
       help.getItems().addAll(about);
       bar.getMenus().addAll(file,edit,help);
       
       dialog.setTitle("Save");
       dialog.setContentText("This is a sample dialog");
       //dialog.getDialogPane().;
        
       
       
       
    
       //CheckMenuItem newItem2 = new CheckMenuItem("check");
    }
    @Override
    public void start(Stage stage) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    BorderPane pane = new BorderPane();
    pane.setTop(bar);
    pane.setCenter(text);
    Scene scene = new Scene(pane,300,400);
    neww.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent t) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        text.clear();
        
        }
        
    });
     exit.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent t) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Platform.exit();
        
        }
        
    });
     select.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent t) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        text.selectAll();
        
        }
        
    });
     delete.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent t) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        text.deleteText(text.getSelection());
        
        }
        
    });
     
     
      copy.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent t) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       text.copy();
        
        }
        
    });
      paste.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent t) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       text.paste();
        
        }
        
    });
      cut.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent t) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        text.cut();
        
        }
        
    });
      undo.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent t) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        text.undo();
        
        }
        
    });
       open.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent t) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        open(stage,text);
        
        }
        
    });
       save.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent t) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        save(stage,text);
        
        }
        
    });
    
    about.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent t) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("about");
        alert.setHeaderText(null);
        alert.setContentText("this is a notepad application");
        alert.showAndWait();
        }
        
    });  
   

      
     
     stage.setTitle("notepad");
    stage.setScene(scene);
        stage.show();
    }
     public void open(Stage stage, TextArea textArea) {
        FileChooser fp = new FileChooser();
        fp.setTitle("choose a file to open");
        java.io.File file = fp.showOpenDialog(stage);
        if (file != null && file.exists()) {
            try {
                
                FileInputStream in = new FileInputStream(file);
                byte[] bs = new byte[(int)file.length()];
                in.read(bs);
               
                textArea.setText(new String(bs));
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    
    public void save(Stage stage, TextArea textArea) {
        FileChooser fc = new FileChooser();
        fc.setTitle("save file");
        java.io.File file = fc.showSaveDialog(stage);
        if (file!=null) {
            
            try {
                
                FileOutputStream out = new FileOutputStream(file);
                out.write(textArea.getText().getBytes());
                out.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
}
