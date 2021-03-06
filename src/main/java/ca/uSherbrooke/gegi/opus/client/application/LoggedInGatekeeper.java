//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ca.uSherbrooke.gegi.opus.client.application;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

@Singleton
public class LoggedInGatekeeper implements Gatekeeper {
    private String nameToken;
    private final PlaceManager placeManager;

    @Inject
    public LoggedInGatekeeper(PlaceManager placeManager) {
        this.placeManager = placeManager;
        this.nameToken = null;
    }

    public boolean canReveal() {
        boolean reveal = false;
        if(this.nameToken == null || this.nameToken.isEmpty()) {
            this.nameToken = this.placeManager.getCurrentPlaceRequest().getNameToken();
        }
        reveal = true;
        if(reveal) {
            System.out.println("Accès autorisé");
        } else {
            System.out.println("Accès refusé");
        }

        this.nameToken = null;
        return reveal;
    }

    public String getNameToken() {
        return this.nameToken;
    }

    public void setNameToken(String nameToken) {
        this.nameToken = nameToken;
    }
}
