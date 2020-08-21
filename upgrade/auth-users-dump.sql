ALTER TABLE Users ADD COLUMN Active boolean;
UPDATE Users SET Active = CASE
 	WHEN username LIKE 'ist%' THEN TRUE
	ELSE FALSE
END;


CREATE TABLE auth_users (
	id integer NOT NULL,
	user_id integer,
	type character varying(255),
	PRIMARY KEY (id),	
	CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);


ALTER TABLE users  ADD COLUMN auth_user_id integer;
ALTER TABLE users ADD CONSTRAINT fk_auth_user FOREIGN KEY (auth_user_id) REFERENCES auth_users(id); 

CREATE SEQUENCE auth_users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE auth_users_id_seq OWNED BY auth_users.id;

ALTER TABLE ONLY auth_users ALTER COLUMN id SET DEFAULT nextval('auth_users_id_seq'::regclass);

SELECT pg_catalog.setval('public.auth_users_id_seq', 737, true);


COPY auth_users (user_id, type) FROM stdin;
616	EXTERNAL
617	EXTERNAL
618	EXTERNAL
619	EXTERNAL
620	EXTERNAL
621	EXTERNAL
622	EXTERNAL
623	EXTERNAL
624	EXTERNAL
625	EXTERNAL
626	EXTERNAL
627	EXTERNAL
628	EXTERNAL
629	EXTERNAL
630	EXTERNAL
631	EXTERNAL
632	EXTERNAL
633	EXTERNAL
634	EXTERNAL
635	EXTERNAL
636	EXTERNAL
637	EXTERNAL
638	EXTERNAL
639	EXTERNAL
640	EXTERNAL
641	EXTERNAL
642	EXTERNAL
643	EXTERNAL
644	EXTERNAL
645	EXTERNAL
646	EXTERNAL
647	EXTERNAL
648	EXTERNAL
649	EXTERNAL
650	EXTERNAL
651	EXTERNAL
652	EXTERNAL
653	EXTERNAL
654	EXTERNAL
655	EXTERNAL
656	EXTERNAL
657	EXTERNAL
658	EXTERNAL
659	EXTERNAL
660	EXTERNAL
661	EXTERNAL
662	EXTERNAL
663	EXTERNAL
664	EXTERNAL
665	EXTERNAL
666	EXTERNAL
667	EXTERNAL
668	EXTERNAL
669	EXTERNAL
670	EXTERNAL
671	EXTERNAL
672	EXTERNAL
673	EXTERNAL
674	EXTERNAL
675	EXTERNAL
676	EXTERNAL
677	EXTERNAL
678	EXTERNAL
679	EXTERNAL
680	EXTERNAL
681	EXTERNAL
682	EXTERNAL
683	EXTERNAL
684	EXTERNAL
685	EXTERNAL
686	EXTERNAL
687	EXTERNAL
688	EXTERNAL
689	EXTERNAL
690	EXTERNAL
691	EXTERNAL
692	EXTERNAL
693	EXTERNAL
694	EXTERNAL
695	EXTERNAL
696	EXTERNAL
697	EXTERNAL
698	EXTERNAL
699	EXTERNAL
700	EXTERNAL
701	EXTERNAL
702	EXTERNAL
703	EXTERNAL
704	EXTERNAL
705	EXTERNAL
706	EXTERNAL
707	EXTERNAL
708	EXTERNAL
709	EXTERNAL
710	EXTERNAL
711	EXTERNAL
712	EXTERNAL
713	EXTERNAL
714	EXTERNAL
715	EXTERNAL
716	EXTERNAL
717	EXTERNAL
718	EXTERNAL
719	EXTERNAL
720	EXTERNAL
721	EXTERNAL
722	EXTERNAL
723	EXTERNAL
724	EXTERNAL
725	EXTERNAL
726	EXTERNAL
727	EXTERNAL
728	EXTERNAL
729	EXTERNAL
730	EXTERNAL
731	EXTERNAL
732	EXTERNAL
733	EXTERNAL
734	EXTERNAL
735	EXTERNAL
736	EXTERNAL
737	EXTERNAL
\.
