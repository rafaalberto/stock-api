(ns stock.handler-integration-test
  (:require [midje.sweet :refer :all]
            [integration-template :refer :all]
            [clj-http.client :as http]
            [cheshire.core :as json]))

(against-background
  [(before :facts [(start-server default-port)])
   (after :facts (stop-server))]
  (fact "The message should be 'Hello Clojure!'" :integration
        (json/parse-string
          (:body (http/get (create-url "/"))) true) => {:message "Hello Clojure!"}))