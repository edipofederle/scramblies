(defproject scramblies "0.1.0-SNAPSHOT"
  :description "scramblies: clj and cljs tasks"
  :url "https://github.com/manuel-uberti/scramblies"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [;; Clojure
                 [cheshire "5.8.0"]
                 [compojure "1.6.1"]
                 [hiccup "1.0.5"]
                 [http-kit "2.3.0"]
                 [metosin/ring-http-response "0.9.0"]
                 [org.clojure/clojure "1.9.0"]
                 [org.clojure/tools.reader "1.2.2"]
                 [ring "1.6.3"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-json "0.4.0"]
                 [ring/ring-mock "0.3.2"]
                 [ring-middleware-format "0.7.2"]

                 ;; ClojureScript
                 [bidi "2.1.3"]
                 [cljs-ajax "0.7.3"]
                 [day8.re-frame/http-fx "0.1.6"]
                 [kibu/pushy "0.3.8"]
                 [org.clojure/clojurescript "1.9.946"]
                 [re-frame "0.10.5"]
                 [reagent "0.8.1"]]

  :plugins [[lein-cljsbuild "1.1.7"]]

  :source-paths ["src/clj"]
  :test-paths ["test/clj" "test/cljs"]
  :resource-paths ["resources"]
  :target-path "target/%s"

  :clean-targets ^{:protect false} [:target-path "resources/public/js"]

  :main ^:skip-aot scramblies.core

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.10"]
                   [cider/piggieback "0.3.6"]
                   [figwheel-sidecar "0.5.16"]]
    :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}
    :plugins [[lein-figwheel "0.5.16"]]}}

  :cljsbuild
  {:builds
   {:dev
    {:source-paths ["src/cljs"]
     :figwheel true
     :compiler
     {:main scramblies.core
      :asset-path "js/out"
      :output-to "resources/public/js/main.js"
      :output-dir "resources/public/js/out"
      :external-config {:devtools/config {:features-to-install :all}}}}}})
