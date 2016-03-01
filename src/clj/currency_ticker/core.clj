(ns currency-ticker.core
  ;;(:use '[clojure.java.io :only ])
  (:require [currency-ticker.process :as process]
            [org.httpkit.server :as server]
            ;[taoensso.sente :as sente]
            ;[taoensso.sente.server-adapters.http-kit :refer (sente-web-server-adapter)]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure.java.io :as io]))



(defn run-daily []
  (doseq [league ["Standard" "Talisman" "Hardcore" "Hardcore+Talisman"]]
    (do (process/daily-pull league)
      (process/process-data league))))

(defn test-run []
  (process/process-data "TEST"))

(defroutes my-routs
  (GET "/" [] (io/resource "public/index.html"))
  (route/resources "/")
  (route/not-found "<p>Page not found.</p>"))

(def app (-> my-routs))
;  (GET "/" "<h1>Hello World</h1>")
;  (GET  "/chsk" req (ring-ajax-get-or-ws-handshake req))
;  (POST "/chsk" req (ring-ajax-post                req)))

;(let [{:keys [ch-recv send-fn ajax-post-fn ajax-get-or-ws-handshake-fn
;              connected-uids]}
;      (sente/make-channel-socket! sente-web-server-adapter {})]
;  (def ring-ajax-post                ajax-post-fn)
;  (def ring-ajax-get-or-ws-handshake ajax-get-or-ws-handshake-fn)
;  (def ch-chsk                       ch-recv) ; ChannelSocket's receive channel
;  (def chsk-send!                    send-fn) ; ChannelSocket's send API fn
;  (def connected-uids                connected-uids) ; Watchable, read-only atom
;  )

;(def my-app
;  (-> my-routes
;      ;; Add necessary Ring middleware:
;      ring.middleware.keyword-params/wrap-keyword-params
;      ring.middleware.params/wrap-params))

