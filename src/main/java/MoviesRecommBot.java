import com.dr3adl0cks.sqliteapp.sqlConnection;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


public class MoviesRecommBot extends TelegramLongPollingBot {


	public void onUpdateReceived(Update update) {

		if (update.hasMessage() && update.getMessage().hasText()) {
			String message_text = update.getMessage().getText();
			long chat_id = update.getMessage().getChatId();
			if (message_text.equals("/start")){
				SendMessage message = new SendMessage().setChatId(chat_id).setText(message_text);
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			else if (update.hasMessage() && update.getMessage().hasPhoto()) {
				//long chat_id = update.getMessage().getChatId();

				// Array with photo objects with different sizes
				// We will get the biggest photo from that array
				List<PhotoSize> photos = update.getMessage().getPhoto();
				// Know file_id
				String f_id = photos.stream()
						.sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
						.findFirst()
						.orElse(null).getFileId();
				// Know photo width
				int f_width = photos.stream()
						.sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
						.findFirst()
						.orElse(null).getWidth();
				// Know photo height
				int f_height = photos.stream()
						.sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
						.findFirst()
						.orElse(null).getHeight();
				// Set photo caption
				String caption = "file_id: " + f_id + "\nwidth: " + f_width + "\nheight: " + f_height;
				SendPhoto msg = new SendPhoto()
						.setChatId(chat_id)
						.setPhoto(f_id)
						.setCaption(caption);
				try {
					execute(msg); // Call method to send the photo with caption
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}


			else if (message_text.equals("/pic")){
				SendPhoto photo = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAIBCF6wPWTLvdVfk3WqCDR1QUycOJkgAAJjqjEbOzqBVTM9mBdhAwEZ-frEanQAAwEAAwIAA3kAA06RAQABGQQ").setCaption("picPhoto");

				try {
					execute(photo);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}
			else if (message_text.equals("/genre")){
				SendMessage message = new SendMessage().setChatId(chat_id).setText("This is your keyboard");

				ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
				List<KeyboardRow> keyboard = new ArrayList<>();

				KeyboardRow keyboardRow = new KeyboardRow();
				keyboardRow.add("Drama movies");
				keyboardRow.add("Thriller movies");
				keyboardRow.add("Sci-fi movies");
				keyboardRow.add("Top Telegram channels");
				keyboard.add(keyboardRow);

				keyboardRow = new KeyboardRow();
				keyboardRow.add("Horror movies");
				keyboardRow.add("Action movies");
				keyboardRow.add("Top Romance");
				keyboardRow.add("Go to IMDB website for more:  ");
				keyboard.add(keyboardRow);
				replyKeyboardMarkup.setKeyboard(keyboard);
				message.setReplyMarkup(replyKeyboardMarkup);

				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}
			else if (message_text.equals("Drama movies")) {
				SendMessage message = new SendMessage().setChatId(chat_id).setText("showing top Drama : ");
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}


           SendPhoto photo0 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAIBCF6wPWTLvdVfk3WqCDR1QUycOJkgAAJjqjEbOzqBVTM9mBdhAwEZ-frEanQAAwEAAwIAA3kAA06RAQABGQQ").setCaption("HER2013");
            SendPhoto photo1 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAIBOV6wUVrdHNSWkFBiFYG8BizqsYLcAAKEqjEbPj6BVWTiFVixoIw-H9--anQAAwEAAwIAA20AA8COAQABGQQ").setCaption("HER2013");
            SendPhoto photo2 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAIBO16wUXpjeyH1ji87xg4BA_g-Ja3yAAKFqjEbPj6BVcaowQ_f5xnnTXXDanQAAwEAAwIAA3kAA3yQAQABGQQ").setCaption("HER2013");
            SendPhoto photo3 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAIBPV6wUa78DX2Vdwd0oHSJNzrUJ5gfAAJvqjEbOzqBVSYlFuP6At409V5manQAAwEAAwIAA3gAA92ZAwABGQQ").setCaption("HER2013");
            SendPhoto photo4 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAIBh16xF4PePT5wUtMqMzEvSvLqxzESAAKBqTEbLQ6IVWoul-VZVjVwgXwda3QAAwEAAwIAA3kAA0cYAAIZBA").setCaption("HER2013");
            SendPhoto photo5 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAIBhV6xF19MHW3226ciMdv9cx4CBiqxAAKAqTEbLQ6IVQhCkxPguFfbVeYYa3QAAwEAAwIAA3gAA-gYAAIZBA").setCaption("HER2013");
            SendPhoto photo6 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAIBiV6xF6OwrgrKSzTXteX37hG_HtVUAAKCqTEbLQ6IVYR2SceehhX5CuYYa3QAAwEAAwIAA3kAA-oYAAIZBA").setCaption("HER2013");
            SendPhoto photo7 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAIBi16xF7lOcR_anUi5Xjm7YkidfQm1AAKDqTEbLQ6IVS3mRWpgSC5-pHTDanQAAwEAAwIAA3kAA_SXAQABGQQ").setCaption("HER2013");
            SendPhoto photo8 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAIBj16xF_xx_3WjEUNQYiWWKMMp8PirAAKEqTEbLQ6IVec5f291hPy0cmfAanQAAwEAAwIAA3kAA6GSAQABGQQ").setCaption("HER2013");
            SendPhoto photo9 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAIBlV6xGEdBqV0X_Qf_12KMn9rqeRuiAAKHqTEbLQ6IVWoLbNfyVTD6kPUba3QAAwEAAwIAA3gAAxUZAAIZBA").setCaption("HER2013");
            SendPhoto photo10 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAIBk16xGCk3EVrPVYKXklYwCLBo3hDHAAKGqTEbLQ6IVcC0HYLpORfT1-cYa3QAAwEAAwIAA3kAAzsaAAIZBA").setCaption("HER2013");

            try {
               execute(photo0);
               execute(photo1);
               execute(photo2);
               execute(photo3);
               execute(photo4);
               execute(photo5);
               execute(photo6);
               execute(photo7);
               execute(photo8);
               execute(photo9);
               execute(photo10);
               execute(photo10);
               execute(photo10);
               execute(photo10);
               execute(photo10);
               execute(photo10);
            } catch (TelegramApiException e) {
               e.printStackTrace();
            }

			}
			else if(message_text.equals("Thriller movies")){
				SendMessage message = new SendMessage().setChatId(chat_id).setText("Showing the top thriller");
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

				SendPhoto photo0 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICiF609sFpY1uLOsSRKo0xpK7bJOUEAAK4qzEbZxGoVXyaZspEQmPMC_VqanQAAwEAAwIAA3kAA_LHAwABGQQ").setCaption("HER2013");
				SendPhoto photo1 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICiV609sGVYWQtMgFWkHmT9uAO99elAAK5qzEbZxGoVXuOfEX2w4SiGeG-anQAAwEAAwIAA3gAA1-2AQABGQQ").setCaption("HER2013");
				SendPhoto photo2 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICil609sJrGeeuvCXVDJ6A0hI6yBxmAAK6qzEbZxGoVSVVQcCKR7S8bvVqanQAAwEAAwIAA3gAA2fEAwABGQQ").setCaption("HER2013");
				SendPhoto photo3 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICi1609sKrXc_nCwP3dTozg0nsarGTAAK7qzEbZxGoVXy5B5-d2xPz67TvanQAAwEAAwIAA3gAA1CsAAIZBA").setCaption("HER2013");
				SendPhoto photo4 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICjV609sK3QSqxH_e4aRo8As0ulmk1AAK8qzEbZxGoVSD7op-oe1fBEHxsanQAAwEAAwIAA3kAA6HHAwABGQQ").setCaption("HER2013");
				SendPhoto photo5 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICjl609sN6j_-IOSc5DatkbL0L0qC3AAK9qzEbZxGoVUzlXLUgIycHN4gga3QAAwEAAwIAA3kAA7U1AAIZBA").setCaption("HER2013");
				SendPhoto photo6 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICkF609sPACywKXr-F66qjs2GuAAFraQACvqsxG2cRqFV8IvSdUA6ORjhsaWp0AAMBAAMCAAN5AAOdxAMAARkE").setCaption("HER2013");
				SendPhoto photo7 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICkl609sNI2sMJx7afjTmWdN4hzpP3AAK_qzEbZxGoVT6ydTEVAAGmxBIDbmp0AAMBAAMCAAN5AAMUyQMAARkE").setCaption("HER2013");
				SendPhoto photo8 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICk1609sOjkECQHpGufsHcfNzZ2z0cAALAqzEbZxGoVQm9HL9xjbSK0mEXa3QAAwEAAwIAA3kAAyo6AAIZBA").setCaption("HER2013");
				SendPhoto photo9 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAIClF609sSvrWId4lFIxEhyV5U3SzYdAALBqzEbZxGoVWr_PpYaEbSDNDrxanQAAwEAAwIAA3gAAymvAAIZBA").setCaption("HER2013");
				SendPhoto photo10 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICl1609sTYbJhBA82imLEkjnIehN0NAALCqzEbZxGoVaFCvAoPUFe-z8DyanQAAwEAAwIAA3kAA-ikAAIZBA").setCaption("HER2013");
				SendPhoto photo11 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICmV609sWeA-8nMnT8kAIht3bp3IBVAALDqzEbZxGoVTrp3iHwJonf8_rEanQAAwEAAwIAA3kAA9O2AQABGQQ").setCaption("HER2013");
				SendPhoto photo12 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICm1609sWuTF4fKS2GA1QMGef53m_HAALEqzEbZxGoVW9JUz1vvxHftF4Xa3QAAwEAAwIAA3kAA2Y6AAIZBA14").setCaption("HER2013");
				SendPhoto photo13 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICnV609sWfXTa7X3yTbf3vIEbEa61SAALFqzEbZxGoVXGDpb7Np5UcW_Mba3QAAwEAAwIAA3kAA6E5AAIZBA").setCaption("HER2013");
				SendPhoto photo14 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICoV609sY_7tHO-VUdhEAIEFLGhOygAALGqzEbZxGoVcsLBsOzrsaXPwFuanQAAwEAAwIAA3kAA1jGAwABGQQ").setCaption("HER2013");
				SendPhoto photo15 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICol609sbjWX8JlxwJPBq3Smy1rlf1AALHqzEbZxGoVXSeamC2zP74pg4ia3QAAwEAAwIAA3kAAxM0AAIZBA").setCaption("HER2013");
				SendPhoto photo16 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICol609sbjWX8JlxwJPBq3Smy1rlf1AALHqzEbZxGoVXSeamC2zP74pg4ia3QAAwEAAwIAA3kAAxM0AAIZBA").setCaption("HER2013");
				//SendPhoto photo12 = new SendPhoto().setChatId(chat_id).setPhoto("").setCaption("HER2013");

				try {
					execute(photo0);
					execute(photo1);
					execute(photo2);
					execute(photo3);
					execute(photo4);
					execute(photo5);
					execute(photo6);
					execute(photo7);
					execute(photo8);
					execute(photo9);
					execute(photo10);
					execute(photo11);
					execute(photo12);
					execute(photo13);
					execute(photo14);
					execute(photo15);
					execute(photo16);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}


			}
			else if (message_text.equals("Top Romance")){
				SendMessage message = new SendMessage().setChatId(chat_id).setText("Showing the top Romance");
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

				SendPhoto photo0 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICbF606Y6xGnRA7DOIcIx8H9fGQ1szAAKmqzEbZxGoVVrm_fY-3JJ4mvzEanQAAwEAAwIAA3kAA_K1AQABGQQ").setCaption("Titanic(1997) imdb : 7.8 telegram link : https://t.me/tmoviesofficial/2055 ");
				SendPhoto photo1 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICbV606Y__wvgvnPRs4CyhH9kSmK9sAAKnqzEbZxGoVUhI5cTwle3NsgFuanQAAwEAAwIAA3kAA869AwABGQQ").setCaption("Amelie(2001)imdb : 8.3 NETFLIX");
				SendPhoto photo2 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICb1606Y8QYqza3NkGh1VBLimxUHUFAAKoqzEbZxGoVTPd6Fvvki1ncy3uanQAAwEAAwIAA3kAA-CnAAIZBA").setCaption("The Princess bride imdb : 8.1 Pirime Video");
				SendPhoto photo3 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICcF606ZAi-Iy0b8VmMU80YvgS76L3AAKpqzEbZxGoVWPqU5GTU3CnffMba3QAAwEAAwIAA3kAA_02AAIZBA").setCaption(" Before Sunriseimdb : 8.1 Netflix");
				SendPhoto photo4 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICcl606ZAXAAE3cmdOmkT3AWSoqvCwwgACqqsxG2cRqFU83ToBTXVEdy9uGmt0AAMBAAMCAAN5AANGNwACGQQ").setCaption("Groundhog Day imdb : 8.0 Netflix");
				SendPhoto photo5 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICc1606ZABykEHjZbZalv-SfT9icWpAAKrqzEbZxGoVaPO2_Jo0yAU5KbsanQAAwEAAwIAA3gAA8ydAAIZBA").setCaption(" Before sunset imdb : 8.0 Prime video");
				SendPhoto photo6 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICdl606ZFV8QV3bh7JIfQcdGlUh0exAAKsqzEbZxGoVQNeqTsG9C0Y0m4aa3QAAwEAAwIAA3kAA842AAIZBA").setCaption("the sound of music imdb :8.0 N/A");
				SendPhoto photo7 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICeV606ZGfdweLXGIxiRP--UXHcxBnAAKtqzEbZxGoVe53CJATW3H38fjEanQAAwEAAwIAA3kAAxG8AQABGQQ").setCaption("Before midnight imdb : 7.9 Amazon prime");
				SendPhoto photo8 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICe1606ZKAbppwP7dmr1Yp_HTeKczKAAKuqzEbZxGoVXJLdQh1UyubcIhvanQAAwEAAwIAA3kAA1fAAwABGQQ").setCaption("Once imdb : 7.8 Amazon prime");
				SendPhoto photo9 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICfl606ZJQus7WHBeZ5UFR2XAv3PtjAAKvqzEbZxGoVSJyPwPGk79oKXXDanQAAwEAAwIAA3kAAyazAQABGQQ").setCaption("The notebook imdb : 7.8 Amazon prime");
				SendPhoto photo10 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICf1606ZNGwZ_scMNdVUh3RwTSVMhMAAKwqzEbZxGoVVzVl6Vuw2_v0PMba3QAAwEAAwIAA3kAA0Q6AAIZBA").setCaption("Veer-Zaara imdb : 7.8 Amzon prime");
				SendPhoto photo11 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICgF606ZPD6juGS35g__yM6af16Wl4AAKxqzEbZxGoVYAg5YpmS4kHEfRqanQAAwEAAwIAA3gAA7_BAwABGQQ").setCaption("The fault in our stars imdb : 7.7 Amazon prime");
				SendPhoto photo12 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICg1606ZMevIt6JGhyNYYhIXApecP6AAKyqzEbZxGoVchQnbQVjQyfd-7BanQAAwEAAwIAA3kAA1i0AQABGQQ").setCaption("About time imdb : 7.8 Netflix");
				SendPhoto photo13 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAIChF606ZOuN6t2Xh9rQexsMeEAAbeQ0wACs6sxG2cRqFUMSt3eVviOFtzuwWp0AAMBAAMCAAN4AAMtsgEAARkE").setCaption("Passengers imdb : 7.0 telegram link : https://t.me/tmoviesofficial/808");
				try {
					execute(photo0);
					execute(photo1);
					execute(photo2);
					execute(photo3);
					execute(photo4);
					execute(photo5);
					execute(photo6);
					execute(photo7);
					execute(photo8);
					execute(photo9);
					execute(photo10);
					execute(photo11);
					execute(photo13);

				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			else if(message_text.equals("Action movies")){
				SendMessage message = new SendMessage().setChatId(chat_id).setText("Showing the top ACTION : ");
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
				SendPhoto photo0 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICql609wbJJIAJSeYJYIMam6tSGuJCAALJqzEbZxGoVdUkArYarJrVoA4ia3QAAwEAAwIAA3kAA54yAAIZBA").setCaption("dunkirk imdb : 7.9 telegram link : https://t.me/tmoviesofficial/1047 ");
				SendPhoto photo1 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICq1609wb60iYSDkGzgKQsT-AdKE2wAALKqzEbZxGoVWsC2JxccuRa_3LDanQAAwEAAwIAA3kAA9u7AQABGQQ").setCaption("Logan imdb : 8.1 telegram link :  https://t.me/tmoviesofficial/924 ");
				SendPhoto photo2 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICrF609wb29c3lN24WBEF3Vh5rRUvHAALLqzEbZxGoVVp71SBmcG_8yrdma3QAAwEAAwIAA3gAAz8HAAIZBA").setCaption("John wick imdb : 7.3 telegram link : https://t.me/tmoviesofficial/943 ");
				SendPhoto photo3 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICrV609wYKUCy1xWvAOSr-UvUw0qEiAALMqzEbZxGoVQFoVKLLdu08yXTDanQAAwEAAwIAA3kAAwe5AQABGQQ").setCaption("The equalizer2 imdb : 6.8 telegram link : https://t.me/tmoviesofficial/1309 ");
				SendPhoto photo4 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICr1609wdmi2EpZ6_d4zUkt9OutT_dAALNqzEbZxGoVe62BAABfhswus11w2p0AAMBAAMCAAN5AAP9ugEAARkE").setCaption("mad max fury road imdb : 8.2 telegram link : https://t.me/tmoviesofficial/1358 ");
				SendPhoto photo5 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICsV609wfnSI9QswUka9d8wDHvl_RjAALOqzEbZxGoVW1TJDeNcqKS5ZMja3QAAwEAAwIAA3gAA_szAAIZBA").setCaption(" 1917 imdb : 8.5 telegram link : https://t.me/tmoviesofficial/2042 ");
				SendPhoto photo6 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICs1609wdK1q4VHo2rTpE99DPcQ5WBAALPqzEbZxGoVRmgBcYVgUkioXoda3QAAwEAAwIAA3gAAwY6AAIZBA").setCaption(" AVATAR imdb : 7.8 telegram link : https://t.me/tmoviesofficial/2175 ");
				SendPhoto photo7 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICtF609whz1xx2qPrYFQ-kIebUu055AALQqzEbZxGoVdewQEHcGrXAXfrEanQAAwEAAwIAA3gAA4O3AQABGQQ").setCaption("Deadpool imdb : 8.3 telegram link :https://t.me/tmoviesofficial/271 ");
				SendPhoto photo8 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICtV609wj4p-4M74wsygaeuAeRHzx3AALRqzEbZxGoVTwMx9IEG6y0_PQba3QAAwEAAwIAA3gAAyU5AAIZBA").setCaption("The equalizer imdb : 7.1 telegram link : https://t.me/tmoviesofficial/1111 ");
				SendPhoto photo9 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICtl609wih1wkJFNNed6-pdnfMgzfKAALSqzEbZxGoVX36pQP2Alcf-g4ia3QAAwEAAwIAA3gAAx8zAAIZBA").setCaption("Avengers all Parts  telegram link :https://t.me/tmoviesofficial ");
				SendPhoto photo10 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICt1609wg4DyC03Qvht3XPLfJwfHwDAALTqzEbZxGoVY58tWzKYWAXM_RqanQAAwEAAwIAA3kAA7LFAwABGQQ").setCaption("Mission Impossible all parts telegram link : https://t.me/tmoviesofficial ");
				SendPhoto photo11 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICuV609wm_npW5VUvcbw3NRMJT7uC9AALUqzEbZxGoVWAk6IFu_-5DgTvxanQAAwEAAwIAA3kAAwuqAAIZBA").setCaption("Extraction imdb : 7.8 telegram link : https://t.me/c/1095729686/2259");
				SendPhoto photo12 = new SendPhoto().setChatId(chat_id).setPhoto("AgACAgUAAxkBAAICvF609wmJRsfRjwzkB_7lSsreutZzAALVqzEbZxGoVa1qL3Kawy91wXkda3QAAwEAAwIAA3kAA4E5AAIZBA").setCaption("baby driver imdb :8.0 telegram limk : https://t.me/tmoviesofficial/1016 ");
				try {
					execute(photo0);
					execute(photo1);
					execute(photo2);
					execute(photo3);
					execute(photo4);
					execute(photo5);
					execute(photo6);
					execute(photo7);
					execute(photo8);
					execute(photo9);
					execute(photo10);
					execute(photo11);
					execute(photo12);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}
			else if(){
				SendMessage message = new SendMessage().setChatId(chat_id).setText("Showing the top ACTION : ");
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}
			else {
				SendMessage message = new SendMessage().setChatId(chat_id).setText("unknown command");
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String getBotUsername() {
		return "MoviesRecomm_bot";
	}

	public String getBotToken() {
		return "1121960357:AAE6H6YwecHpbXDjImKBEgd81wlVz_D0Ymw";
	}
}