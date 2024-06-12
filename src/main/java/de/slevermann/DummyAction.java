package de.slevermann;

import org.keycloak.authentication.RequiredActionContext;
import org.keycloak.authentication.RequiredActionProvider;

public class DummyAction implements RequiredActionProvider {
    @Override
    public void evaluateTriggers(RequiredActionContext requiredActionContext) {
        final var user = requiredActionContext.getUser();
        if (user.getFirstAttribute("dummy") == null) {
            requiredActionContext.getUser().addRequiredAction(DummyActionFactory.ID);
        }
    }

    @Override
    public void requiredActionChallenge(RequiredActionContext requiredActionContext) {
        requiredActionContext.challenge(requiredActionContext.form().createForm("dummy.ftl"));
    }

    @Override
    public void processAction(RequiredActionContext requiredActionContext) {
        final var params = requiredActionContext
                .getHttpRequest()
                .getDecodedFormParameters();
        if (params.containsKey("doFailure")) {
            requiredActionContext.failure();
            requiredActionContext.getAuthenticationSession().getParentSession().restartSession(requiredActionContext.getRealm());
            return;
        }
        if (params.containsKey("doSuccess")) {
            requiredActionContext.getUser().setSingleAttribute("dummy", "dummy");
            requiredActionContext.success();
        }
    }

    @Override
    public void close() {

    }
}
