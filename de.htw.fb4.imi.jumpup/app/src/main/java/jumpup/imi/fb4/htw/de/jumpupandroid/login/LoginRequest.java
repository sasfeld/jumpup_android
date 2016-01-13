package jumpup.imi.fb4.htw.de.jumpupandroid.login;

import android.net.Uri;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import jumpup.imi.fb4.htw.de.jumpupandroid.entities.User;
import jumpup.imi.fb4.htw.de.jumpupandroid.util.webservice.Endpoints;
import jumpup.imi.fb4.htw.de.jumpupandroid.util.webservice.JumpUpRequest;
import jumpup.imi.fb4.htw.de.jumpupandroid.util.webservice.Versions;

/**
 * Project: jumpup_android
 * <p/>
 * This class models a LoginRequest that is sent to the JumpUp mobile REST service.
 *
 * @author Sascha Feldmann <a href="mailto:sascha.feldmann@gmx.de">sascha.feldmann@gmx.de</a>
 * @since ${date}
 */
public class LoginRequest extends JumpUpRequest {
    private final String TARGET_VERSION = Versions.V1_0_0.getUrlPart();
    private final String ENDPOINT = Endpoints.USER;

    @Override
    public boolean isPublicAction() {
        return false;
    }

    @Override
    public String getTargetVersion() {
        return TARGET_VERSION;
    }

    @Override
    public String getEndpointUrl() {
        return ENDPOINT;
    }

    /**
     * Trigger the login.
     * @param username
     * @param password
     * @return
     */
    public User triggerLogin(String username, String password) {
        Uri loginUri = Uri.parse(this.getEndpointUrl());
        HttpURLConnection urlConnection = null;

        try {
            URL loginUrl = new URL(loginUri.toString());

             urlConnection = (HttpURLConnection) loginUrl.openConnection();

            // TODO trigger connection
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
