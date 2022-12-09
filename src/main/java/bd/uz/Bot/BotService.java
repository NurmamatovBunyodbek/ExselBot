package bd.uz.Bot;


import bd.uz.service.Service;
import bd.uz.service.Users;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import java.io.File;
public class BotService {

    public SendDocument getExsel (Long chatId){

        SendDocument sendDocument = new SendDocument();

        sendDocument.setChatId(chatId);

        sendDocument.setDocument(new InputFile(new File("C:\\PDP Academy\\users.xlsx")));
        return sendDocument;
    }

    public SendMessage usersList(Long chatId){
        String s="";
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        Service service = new Service();
        for (Users u : service.getList()  ) {
            s+="Id : "+u.getId() +"\n"+" Name : "+ u.getName()+"\n"+ " UserName :"+ u.getUsername()+"\n"+
                    " Email :"+ u.getEmail()+"\n"+ " Street  :" + u.getAddress().getStreet()+"\n"+
                    " Suite :" + u.getAddress().getSuite()+"\n"+  " City :"+ u.getAddress().getCity()+"\n"+
                    " Zipcode :" + u.getAddress().getZipcode()+ " Lat :"+ u.getAddress().getGeo().getLat()+
                    " Lng :"+ u.getAddress().getGeo().getLat()+"\n"+  "Phone :" + u.getPhone()+"\n"+" Website :" + u.getWebsite()+"\n"+
                    " Company name "+ u.getCompany().getName()+ " catchPhrase" + u.getCompany().getCatchPhrase()+
                    " Bs :" + u.getCompany().getBs()+"\n"+"\n\n";
        }
        sendMessage.setText(s);
        return sendMessage;
    }

}


