package com.edukators.netflix.service;
import com.edukators.netflix.model.subscription;
import com.edukators.netflix.service.subscriptionService;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class subscriptionService {
    private final List<subscription> subscriptions = new ArrayList<>();

    // Retrieve all subscriptions
    public List<subscription> getAllSubscriptions() {
        return new ArrayList<>(subscriptions); // Return a copy to avoid external modifications
    }

    // Retrieve subscription by ID
    public subscription getSubscriptionById(String id) {
        return subscriptions.stream()
                .filter(subscription -> subscription.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Subscription not found with ID: " + id));
    }

    // Add a new subscription
    public void addSubscription(subscription subscription) {
        if (subscriptions.stream().anyMatch(existingSubscription -> existingSubscription.getId().equals(subscription.getId()))) {
            throw new IllegalArgumentException("Subscription with ID " + subscription.getId() + " already exists");
        }
        subscriptions.add(subscription);
    }

    // Update an existing subscription
    public void updateSubscription(String id, subscription updatedSubscription) {
        subscription existingSubscription = getSubscriptionById(id); // Will throw if subscription doesn't exist
        existingSubscription.setPlanName(updatedSubscription.getPlanName() != null ? updatedSubscription.getPlanName() : existingSubscription.getPlanName());
        existingSubscription.setPlanDescription(updatedSubscription.getPlanDescription() != null ? updatedSubscription.getPlanDescription() : existingSubscription.getPlanDescription());
        existingSubscription.setPrice(updatedSubscription.getPrice() != null ? updatedSubscription.getPrice() : existingSubscription.getPrice());
        existingSubscription.setMaxProfile(updatedSubscription.getMaxProfile() > 0 ? updatedSubscription.getMaxProfile() : existingSubscription.getMaxProfile());
        existingSubscription.setSupportsHD(updatedSubscription.getSupportsHD() != null ? updatedSubscription.getSupportsHD() : existingSubscription.getSupportsHD());
        existingSubscription.setSupportsUHD(updatedSubscription.getSupportsUHD() != null ? updatedSubscription.getSupportsUHD() : existingSubscription.getSupportsUHD());
    }

    // Delete a subscription by ID
    public void deleteSubscription(String id) {
        subscription subscription = getSubscriptionById(id); // Will throw if subscription doesn't exist
        subscriptions.remove(subscription);
    }
}
