package jumpup.imi.fb4.htw.de.jumpupandroid.util.webservice;

/**
 * Project: jumpup_android
 * <p/>
 * Abstract class for all requests that are sent to the JumpUp mobile API REST service.
 *
 * @author Sascha Feldmann <a href="mailto:sascha.feldmann@gmx.de">sascha.feldmann@gmx.de</a>
 * @since ${date}
 */
public abstract class JumpUpRequest {
    private String builtUrl;

    /**
     * Get the targeted version URL part. E.g. "v1.0.0".
     * @return
     */
    public abstract String getTargetVersion();

    /**
     * Get the endpoint URL part of the targeted service. E.g. "user".
     * @return
     */
    public abstract String getEndpointUrl();

    /**
     * Check whether this action is public (does not need an authentication).
     * This means, the service will be available under a "public" URL part. E.G. http://groupelite.de:8080/jumpup/rest/v1.0.0/public/user/1.
     * @return
     */
    public abstract boolean isPublicAction();

    /**
     * Get the base URL to the JumpUp REST service.
     * This does not include the version. Use getTargetVersion().
     * @return
     */
    public String getBaseUrl()
    {
        // TODO get from build config.
        return "http://groupelite.de:8080/jumpup/rest";
    }

    /**
     * Get the complete URL to address the JumpUp REST service.
     * @return
     */
    public String getUrl()
    {
        if (null == builtUrl) {
            builtUrl = buildUrl();
        }

        return builtUrl;
    }

    private String buildUrl() {
        return getBaseUrl() + "/" + getTargetVersion() + this.addPublicPart() + "/" + getEndpointUrl();
    }

    private String addPublicPart() {
        if (isPublicAction()) {
            return "/" + "public";
        }

        return "";
    }
}
