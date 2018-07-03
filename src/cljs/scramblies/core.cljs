(ns scramblies.core
  (:require [day8.re-frame.http-fx]
            [re-frame.core :as rf]
            [reagent.core :as reagent]
            [scramblies.events]
            [scramblies.home.events]
            [scramblies.home.subs]
            [scramblies.routes :as routes]
            [scramblies.subs]
            [scramblies.views :as views]))

(defn main-panel
  []
  (let [active-panel (rf/subscribe [:active-panel])]
    (fn []
      [views/show-panel @active-panel])))

(defn mount-root
  []
  (rf/clear-subscription-cache!)
  (reagent/render [main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init
  []
  (routes/app-routes)
  (rf/dispatch-sync [:initialize-db])
  (mount-root))
