/* A1 */
select g from GOALS as g where g.beauty > 0.9 or g.beauty < 0.1;

/* A2 */
select p from PLAYERS as p inner join GOALS as g on p.player_id = g.player_id
where p.team = 'FCB' and p.goal_id >= 1

/* A3 */
select p from PLAYERS as p inner join GOALS as g on p.player_id = g.player_id
where p.team = 'FCB' and p.market_value < 8.0
having count(p.goal_id) >= 10

/* A4 */
select p.team, p.homeland, count(g.goal_id) as num_of_goals from PLAYERS as p inner join GOALS as g on p.player_id = g.player_id
where g.timestamp = '2016-11-22'
group by p.team, p.homeland

/* A5 */
select AVG(g.beauty) as avg_pdg_beauty from PLAYERS as p inner join GOALS as g on p.player_id = g.player_id
where p.team = 'PSG'

/* B */
/* because we are using innner join, and it only keep non null */
select A.player_id, B.goal_id from PLAYERS AS A left join GOALS AS B on A.player_id = B.player_id

/* C */
select A.player_id, B.goal_id from PLAYERS AS A left join GOALS AS B on A.player_id = B.player_id
where B.player_id is null
