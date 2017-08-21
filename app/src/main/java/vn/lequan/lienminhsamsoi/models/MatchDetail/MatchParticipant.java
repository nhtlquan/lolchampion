
package vn.lequan.lienminhsamsoi.models.MatchDetail;

public class MatchParticipant {

    public MatchParticipant(Participant participants, ParticipantIdentity participantIdentities) {
        this.participants = participants;
        this.participantIdentities = participantIdentities;
    }

    private Participant participants = null;
    private ParticipantIdentity participantIdentities = null;

    public Participant getParticipants() {
        return participants;
    }

    public void setParticipants(Participant participants) {
        this.participants = participants;
    }

    public ParticipantIdentity getParticipantIdentities() {
        return participantIdentities;
    }

    public void setParticipantIdentities(ParticipantIdentity participantIdentities) {
        this.participantIdentities = participantIdentities;
    }

}
