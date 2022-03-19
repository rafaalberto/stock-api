(ns stock.handler-integration-test
  (:require [midje.sweet :refer :all]
            [stock.handler :refer [app]]
            [clj-http.client :as http]
            [cheshire.core :as json]
            [ring.adapter.jetty :refer [run-jetty]]))

(def server (atom nil))

(defn start-server [port]
  (swap! server
         (fn [_] (run-jetty app {:port port :join? false}))))

(defn stop-server []
  (.stop @server))

(def default-port 3001)

(defn create-url [route]
  (str "http://localhost:" default-port route))

(against-background
  [(before :facts [(start-server default-port)])
   (after :facts (stop-server))]
  (fact "The message should be 'Hello World'" :integration
        (json/parse-string (:body (http/get (create-url "/"))) true) => {:message "Hello World"}))