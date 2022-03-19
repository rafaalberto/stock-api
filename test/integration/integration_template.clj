(ns integration-template
  (:require [stock.handler :refer [app]]
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