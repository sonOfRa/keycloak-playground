package de.slevermann;

import com.google.auto.service.AutoService;
import org.keycloak.Config;
import org.keycloak.authentication.RequiredActionFactory;
import org.keycloak.authentication.RequiredActionProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

@AutoService(RequiredActionFactory.class)
public class DummyActionFactory implements RequiredActionFactory {

    public static final String ID = "dummy-action";

    @Override
    public String getDisplayText() {
        return "Dummy action";
    }

    @Override
    public RequiredActionProvider create(KeycloakSession keycloakSession) {
        return new DummyAction();
    }

    @Override
    public void init(Config.Scope scope) {

    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {

    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return ID;
    }
}
