package ro.andreimihaescu.dto;

public class RoleRequest {

    private Long userId;
    private String subscriptionType;
    private String roleType;

    public RoleRequest(Long userId, String subscriptionType, String roleType) {
        this.userId = userId;
        this.subscriptionType = subscriptionType;
        this.roleType = roleType;
    }

    public  RoleRequest(Long userId, UserRequest userRequest){
        this.userId = userId;
        this.subscriptionType = userRequest.getSubscriptionType();
        this.roleType = userRequest.getSubscriptionType();
    }

    public Long getUserId() {
        return userId;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public String getRoleType() {
        return roleType;
    }
}
