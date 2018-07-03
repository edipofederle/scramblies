(ns scramblies.views
  (:require [scramblies.home.views :as home-views]))

(defn- panels
  [panel-name]
  (case panel-name
    :scramblies-home-panel [home-views/home-panel]
    [:div]))

(defn show-panel
  [panel-name]
  [panels panel-name])
