package Demo2_2_as_dynamic_web_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v1.DbxClientV1;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderErrorException;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.files.UploadErrorException;
import com.dropbox.core.v2.users.FullAccount;

/**
 * @author Janita
 * @version 16.9.2018
 *
 */
public class DropBox {
	
	private static String accessToken = "N765u51umFAAAAAAAAAAD0215VTEJqEbUFdv6PrvS4WkOpMAU_BLzFg5d7gU1YJO";

	/**
	 * @param args not used
	 * @throws DbxException exception
	 * @throws ListFolderErrorException exception 
	 * @throws IOException exception
	 * @throws FileNotFoundException exception 
	 */
	public static void main(String[] args) throws ListFolderErrorException, DbxException, FileNotFoundException, IOException {
		String accessToken = "N765u51umFAAAAAAAAAAD0215VTEJqEbUFdv6PrvS4WkOpMAU_BLzFg5d7gU1YJO";
		DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, accessToken);
        
        FullAccount account;
		try {
			account = client.users().getCurrentAccount();
	        System.out.println(account.getAccountId());
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DbxClientV2 getClient() {
		DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/app").build();
        DbxClientV2 client = new DbxClientV2(config, accessToken);
        return client;
	}
	
	public String getAccountUserName(DbxClientV2 client) {
		FullAccount account;
		try {
			account = client.users().getCurrentAccount();
	        return account.getName().getDisplayName();
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Couldn't connect to DropBox account";
	}
	
	public void uploadToDropBox(DbxClientV2 client, File file) throws FileNotFoundException, IOException, UploadErrorException, DbxException {
		try (InputStream in = new FileInputStream(file)) {
            FileMetadata metadata = client.files().uploadBuilder("/" + file.getName())
                .uploadAndFinish(in);
        }
	}
	
	public List<String> getListOfCurrentFiles(DbxClientV2 client) throws ListFolderErrorException, DbxException {
		List<String> listOfFiles = new ArrayList<>();
		ListFolderResult result = client.files().listFolder("");
        while (true) {
            for (Metadata metadata : result.getEntries()) {
                listOfFiles.add(metadata.getPathLower());
            }

            if (!result.getHasMore()) {
                break;
            }

            try {
				result = client.files().listFolderContinue(result.getCursor());
			} catch (DbxException e) {
				e.printStackTrace();
			}
        }
        
        return listOfFiles;
	}
	
	public void createFolder(DbxClientV1 client, String name) throws DbxException {
		client.createFolder(name);
	}

}
