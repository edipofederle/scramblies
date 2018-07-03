(ns scramblies.home.events
  (:require [scramblies.ajax :as ajax]
            [re-frame.core :as rf]))

(rf/reg-event-db
 :home-change-s1
 (fn [db [_ value]]
   (-> db
       (assoc :s1 value)
       (assoc :message nil))))

(rf/reg-event-db
 :home-change-s2
 (fn [db [_ value]]
   (-> db
       (assoc :s2 value)
       (assoc :message nil))))

(rf/reg-event-fx
 :scramble
 (fn [{db :db} [_ _]]
   (let [body (select-keys db [:s1 :s2])]
     (ajax/post-request "/api/scramble"
                        body
                        [:show-message]
                        [:bad-response]))))

(rf/reg-event-db
 :show-message
 (fn [db [_ {result :scramble?}]]
   (if result
     (assoc db :message "Yes, you have a match!")
     (assoc db :message "No, there isn't a match!"))))
