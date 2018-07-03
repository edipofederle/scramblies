(ns scramblies.templates
  (:require [hiccup.page :as hiccup]))

(defn index-html
  "scramblies main index."
  []
  (hiccup/html5
   {:lang "it"}
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
    [:meta
     {:name "viewport"
      :content "width=device-width, initial-scale=1.0, maximum-scale=1.0"}]
    [:title "Scramblies"]
    (hiccup/include-css "/css/scramblies.css")]
   [:body
    [:div#app]
    (hiccup/include-js "/js/main.js")
    [:script "scramblies.core.init();"]]))
