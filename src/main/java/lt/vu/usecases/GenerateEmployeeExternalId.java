package lt.vu.usecases;

import lt.vu.interceptors.LoggedInvocation;
import lt.vu.services.ExternalIdGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateEmployeeExternalId implements Serializable {
    @Inject
    ExternalIdGenerator externalIdGenerator;

    private CompletableFuture<Integer> externalIdGenerationTask = null;

    @LoggedInvocation
    public String generateNewExternalId() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        externalIdGenerationTask = CompletableFuture.supplyAsync(() -> externalIdGenerator.generateExternalId());

        return  "/employeeDetails.xhtml?faces-redirect=true&employeeId=" + requestParameters.get("employeeId");
    }

    public boolean isExternalIdGenerationRunning() {
        return externalIdGenerationTask != null && !externalIdGenerationTask.isDone();
    }

    public String getExternalIdStatus() throws ExecutionException, InterruptedException {
        if (externalIdGenerationTask == null) {
            return null;
        } else if (isExternalIdGenerationRunning()) {
            return "External id generation in progress";
        }
        return "Suggested External id: " + externalIdGenerationTask.get();
    }
}
