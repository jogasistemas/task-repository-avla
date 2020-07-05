--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12.1

-- Started on 2020-07-04 03:09:08

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 202 (class 1259 OID 49576)
-- Name: task_seq_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.task_seq_id
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.task_seq_id OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 204 (class 1259 OID 49580)
-- Name: tasks; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tasks (
    id integer NOT NULL,
    create_date timestamp without time zone,
    description character varying(255),
    finished boolean NOT NULL,
    status smallint NOT NULL,
    title character varying(255),
    user_id integer
);


ALTER TABLE public.tasks OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 49578)
-- Name: user_seq_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_seq_id
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_seq_id OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 49588)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    last_names character varying(255),
    names character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 2828 (class 0 OID 49580)
-- Dependencies: 204
-- Data for Name: tasks; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tasks (id, create_date, description, finished, status, title, user_id) FROM stdin;
251	2020-07-04 02:01:55.452	completar crud	f	1	completar crud	1
301	2020-07-04 02:14:13.743	completar crud	f	1	completar crud	1
1	\N	implementar listado	f	0	listar tareas	\N
2	\N	implementar guardar	f	0	guardar tarea	\N
3	\N	implementar eliminar	f	0	eliminar tarea	\N
4	\N	implementar actualizar	f	0	update tarea	\N
351	2020-07-04 02:22:21.705	completar crud	f	0	completar crud	\N
401	\N	completar crud 3	f	2	completar crud 3	1
\.


--
-- TOC entry 2829 (class 0 OID 49588)
-- Dependencies: 205
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, last_names, names) FROM stdin;
1	maldi	palteo
2	willchon	willchongo
\.


--
-- TOC entry 2835 (class 0 OID 0)
-- Dependencies: 202
-- Name: task_seq_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.task_seq_id', 451, true);


--
-- TOC entry 2836 (class 0 OID 0)
-- Dependencies: 203
-- Name: user_seq_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_seq_id', 1, false);


--
-- TOC entry 2696 (class 2606 OID 49587)
-- Name: tasks tasks_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (id);


--
-- TOC entry 2698 (class 2606 OID 49595)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2699 (class 2606 OID 49596)
-- Name: tasks fk_task_user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT fk_task_user_id FOREIGN KEY (user_id) REFERENCES public.users(id);


-- Completed on 2020-07-04 03:09:08

--
-- PostgreSQL database dump complete
--

