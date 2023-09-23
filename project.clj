(defproject rendemb "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name ""
            :url ""}
  :clean-targets ^{:protect false} [:target-path "out" "resources/public/js"]
  :min-lein-version "2.5.3"
  :repl-options {:init-ns dev.repl}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.520"]
                 ;-------
                 [org.clojure/core.async "0.4.474"]
                 [cljs-http "0.1.18"]
                 [ring/ring-json "0.5.0"]
                 [ring/ring-defaults "0.3.2"]
                 ;-------
                 [reagent "0.9.0-rc1"]
                 [compojure "1.6.1"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [ring/ring-ssl "0.3.0"]
                 [environ "1.1.0"]]

  :plugins [[lein-environ "1.1.0" :hooks false]
            [lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.19"]]

  :main rendemb.web/-main

  :figwheel {:css-dirs ["resources/public/css"]
             :server-port 3450}
  :uberjar-name "rendemb.jar"
  :profiles {:dev {:dependencies [[cider/piggieback "0.4.1"]
                                  [figwheel-sidecar "0.5.18"]
                                  [binaryage/devtools "0.9.10"]
                                  [cljs-ajax "0.8.4"]
                                  [jayq "0.1.0-alpha3"]
                                  ;[reagent "0.8.1" :exclusions [[cljsjs/react]]
                                  ;                             [cljsjs/react-dom]
                                  ;                             [cljsjs/create-react-class]]
                                  [re-frame "0.10.6"]]
                   :source-paths ["src" "dev"]
                   :cljsbuild {:builds [{:id "dev"
                                         :source-paths ["src"]
                                         :figwheel true
                                         :compiler {:main "rendemb.core"
                                                    :externs ["resources/public/lib/jquery.dataTables.js"]
                                                    :preloads [devtools.preload]
                                                    :asset-path "js/out"
                                                    :output-to "resources/public/js/main.js"
                                                    :output-dir "resources/public/js/out"
                                                    :optimizations :none
                                                    :recompile-dependents true
                                                    :source-map true}}]}}
             :uberjar {:env {:production true}
                       :source-paths ["src"]
                       :prep-tasks ["compile" ["cljsbuild" "once"]]
                       :cljsbuild {:builds [{:id "production"
                                             :source-paths ["src"]
                                             :jar true
                                             :compiler {:main "rendemb.core"
                                                        :asset-path "js/out"
                                                        :output-to "resources/public/js/main.js"
                                                        :output-dir "resources/public/js/out"
                                                        :optimizations :advanced
                                                        :pretty-print false}}]}}})
