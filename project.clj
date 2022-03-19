(defproject stock-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :uberjar-name "stock-api.jar"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [compojure "1.6.2"]
                 [ring/ring-defaults "0.3.3"]]
  :plugins [[lein-ring "0.12.6"]]
  :ring {:handler stock-api.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.4.0"]]
         :plugins      [[lein-cloverage "1.0.13"]]}})
