-- table on disk
with sizes as (
    SELECT
    pg_table_size('json_integer') as int_size,
    pg_table_size('json_uuid') as uuid_size
)
select
int_size,
uuid_size,
1 - int_size::numeric/uuid_size as more
from
sizes;

-- total on disk
with sizes as (
    SELECT
    pg_total_relation_size('json_integer') as int_size,
    pg_total_relation_size('json_uuid') as uuid_size
)
select
int_size,
uuid_size,
1 - int_size::numeric/uuid_size as more
from
sizes;


-- text to jsonb
ALTER TABLE json_specialj ALTER COLUMN text TYPE jsonb USING text::jsonb;
VACUUM ANALYZE json_specialj;

with sizes as (
    SELECT
    pg_total_relation_size('json_specialj') as special_j,
    pg_total_relation_size('json_uuid') as regular_text
)
select
special_j,
regular_text,
special_j::numeric/regular_text as ratio
from
sizes;
