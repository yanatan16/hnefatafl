(defproject hnefatafl "0.1.0-SNAPSHOT"
  :description "Hnefatafal"
  :url "http://yanatan16.github.io/hnefatafal"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2156"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [om "0.5.0"]]

  :plugins [[lein-cljsbuild "1.0.2"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "hnefatafl"
              :source-paths ["src"]
              :compiler {
                :output-to "resources/public/js/tafl.js"
                :output-dir "resources/public/js/out"
                :optimizations :none
                :source-map true}}]})
