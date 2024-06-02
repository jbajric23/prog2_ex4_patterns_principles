package at.ac.fhcampuswien.fhmdb.api;

/*
public class UrlBuilder {

    private String protocol = "https";
    private String domain;
    private String path;
    private String query;

    public UrlBuilder withProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    public UrlBuilder withDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public UrlBuilder withPath(String path) {
        this.path = path;
        return this;
    }

    public UrlBuilder withQuery(String query) {
        this.query = query;
        return this;
    }

    public String build() {
        StringBuilder url = new StringBuilder();

        url.append(protocol).append("://");

        if (domain != null) {
            url.append(domain);
        }

        if (path != null) {
            url.append("/").append(path);
        }

        if (query != null) {
            url.append("?").append(query);
        }

        return url.toString();
    }
}
*/