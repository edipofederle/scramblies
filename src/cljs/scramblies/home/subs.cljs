(ns scramblies.home.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
 :s1
 (fn [db _]
   (:s1 db)))

(rf/reg-sub
 :s2
 (fn [db _]
   (:s2 db)))

(rf/reg-sub
 :message
 (fn [db _]
   (:message db)))
