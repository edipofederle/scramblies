(ns scramblies.events
  (:require [re-frame.core :as rf]
            [scramblies.ajax :as ajax]
            [scramblies.db :as db]))

(rf/reg-event-db
 :initialize-db
 (fn [_ _]
   db/default-db))

(rf/reg-event-db
 :set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(rf/reg-event-fx
 :bad-response
 (fn [{db :db} [_ response]]
   (.log js/console (get-in response [:response :error]))))
