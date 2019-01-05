package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class DaoController {
    public Button izmjeniDrzavuBtn;
    public Button dodajDrzavuBtn;
    public Button izmjeniGradBtn;
    public Button dodajGradBtn;
    public Button obrisiGradBtn;
    public Button obrisiDrzavuBtn;
    public Button ispisiGradoveBtn;
    public GeografijaDAO geo= null;
    public TextField idGradPolje;
    public TextField idDrzavaPolje;
    public TextField nazivGradPolje;
    public TextField brojStanovnikaGradPolje;
    public TextField nazivDzavaPolje;



    public void initialize () {
        geo = GeografijaDAO.getInstance();
    }

    public void izmjeniDrzavu(ActionEvent actionEvent) {
        String pom = nazivDzavaPolje.getText();
        Drzava drz=geo.nadjiDrzavu(pom);
        geo.izmijeniDrzava(drz);
    }

    public void dodajDrzavu(ActionEvent actionEvent) {
        String pom=nazivDzavaPolje.getText();
        Drzava drz= new Drzava();
        int id =idDrzavaPolje.getPrefColumnCount();
        drz.setId(id);
        drz.setNaziv(pom);
        drz.setGlavniGrad(null);
        geo.dodajDrzavu(drz);
    }

    public void izmjeniGrad(ActionEvent actionEvent) {
        String pom = nazivGradPolje.getText();
        Grad grad=new Grad();
        grad.setId(idGradPolje.getPrefColumnCount());
        grad.setNaziv(pom);
        grad.setBrojStanovnika(brojStanovnikaGradPolje.getPrefColumnCount());
        grad.setDrzava(null);
        geo.izmijeniGrad(grad);
    }

    public void dodajGrad(ActionEvent actionEvent) {
        String pom = nazivGradPolje.getText();
        Grad grad=new Grad();
        grad.setId(idGradPolje.getPrefColumnCount());
        grad.setNaziv(pom);
        grad.setBrojStanovnika(brojStanovnikaGradPolje.getPrefColumnCount());
        grad.setDrzava(null);
        geo.dodajGrad(grad);
    }

    public void obrisiGrad(ActionEvent actionEvent) {
        String pom=nazivGradPolje.getText();
        geo.obrisiGrad(pom);
    }

    public void obrisiDrzavu(ActionEvent actionEvent) {
        String pom=nazivDzavaPolje.getText();
        geo.obrisiDrzavu(pom);
    }

    public void ispisiGradove(ActionEvent actionEvent) {
        try {
            new GradoviReport().showReport(GeografijaDAO.getInstance().getConnection());
        } catch (JRException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void francuski(ActionEvent actionEvent) {
        Locale.setDefault(new Locale("fr", "FR"));
        Stage myStage = (Stage) dodajDrzavuBtn.getScene().getWindow();
        ResourceBundle bundle = ResourceBundle.getBundle("Translation_fr");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dao.fxml"), bundle);
        loader.setController(new DaoController());
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.show();
    }

    public void bosanski(ActionEvent actionEvent) {
        Locale.setDefault(new Locale("bs", "BA"));
        Stage myStage = (Stage) dodajDrzavuBtn.getScene().getWindow();
        ResourceBundle bundle = ResourceBundle.getBundle("Translation_bs");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dao.fxml"), bundle);
        loader.setController(new DaoController());
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.show();
    }

    public void engleski(ActionEvent actionEvent) {
        Locale.setDefault(new Locale("en", "US"));
        Stage myStage = (Stage) dodajDrzavuBtn.getScene().getWindow();
        ResourceBundle bundle = ResourceBundle.getBundle("Translation_en_US");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dao.fxml"), bundle);
        loader.setController(new DaoController());
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.show();
    }

    public void njemacki(ActionEvent actionEvent) {
        Locale.setDefault(new Locale("de", "DE"));
        Stage myStage = (Stage) dodajDrzavuBtn.getScene().getWindow();
        ResourceBundle bundle = ResourceBundle.getBundle("Translation_de");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dao.fxml"), bundle);
        loader.setController(new DaoController());
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.show();
    }


}
