(ns scramblies.subs
  (:require [re-frame.core :as rf])  
  (:require-macros [reagent.ratom :as r]))

(rf/reg-sub
 :active-panel
 (fn [db _]
   (:active-panel db)))
