(ns scramblies.home.views
  (:require [scramblies.validation :as v]
            [re-frame.core :as rf]))

(defn message
  []
  (fn []
    (when-let [msg @(rf/subscribe [:message])]
      [:h3 msg])))

(defn home-panel
  []
  (fn []
    (let [s1 (rf/subscribe [:s1])
          s2 (rf/subscribe [:s2])]
      [:div.container
       [:h1 "Scramblies"]
       [:p
        [:em
         "Insert two strings and check if some characters of the first one can
         be rearranged to match the second one."]]
       [:div
        [:div
         {:style {:text-align "left"}}
         [:label [:strong "First string"]]
         [:input
          {:type "text"
           :value (v/or-empty-string @s1)
           :on-change #(rf/dispatch [:home-change-s1
                                     (-> % .-target .-value)])}]]
        [:div
         {:style {:text-align "left"}}
         [:label [:strong "Second string"]]
         [:input
          {:type "text"
           :value (v/or-empty-string @s2)
           :on-change #(rf/dispatch [:home-change-s2
                                     (-> % .-target .-value)])}]]
        [:button.button
         {:type "button"
          :on-click #(rf/dispatch [:scramble])}
         "Go!"]

        [message]]])))
