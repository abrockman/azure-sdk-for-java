/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.batch.protocol.models;

import java.util.List;
import org.joda.time.Period;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Job Release task to run on job completion on any compute node where the
 * job has run.
 * The Job Release task runs when the job ends, because of one of the
 * following: The user calls the Terminate Job API, or the Delete Job API while
 * the job is still active, the job's maximum wall clock time constraint is
 * reached, and the job is still active, or the job's Job Manager task
 * completed, and the job is configured to terminate when the Job Manager
 * completes. The Job Release task runs on each compute node where tasks of the
 * job have run and the Job Preparation task ran and completed. If you reimage
 * a compute node after it has run the Job Preparation task, and the job ends
 * without any further tasks of the job running on that compute node (and hence
 * the Job Preparation task does not re-run), then the Job Release task does
 * not run on that node. If a compute node reboots while the Job Release task
 * is still running, the Job Release task runs again when the compute node
 * starts up. The job is not marked as complete until all Job Release tasks
 * have completed. The Job Release task runs in the background. It does not
 * occupy a scheduling slot; that is, it does not count towards the
 * maxTasksPerNode limit specified on the pool.
 */
public class JobReleaseTask {
    /**
     * A string that uniquely identifies the Job Release task within the job.
     * The ID can contain any combination of alphanumeric characters including
     * hyphens and underscores and cannot contain more than 64 characters. If
     * you do not specify this property, the Batch service assigns a default
     * value of 'jobrelease'. No other task in the job can have the same ID as
     * the Job Release task. If you try to submit a task with the same id, the
     * Batch service rejects the request with error code
     * TaskIdSameAsJobReleaseTask; if you are calling the REST API directly,
     * the HTTP status code is 409 (Conflict).
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * The command line of the Job Release task.
     * The command line does not run under a shell, and therefore cannot take
     * advantage of shell features such as environment variable expansion. If
     * you want to take advantage of such features, you should invoke the shell
     * in the command line, for example using "cmd /c MyCommand" in Windows or
     * "/bin/sh -c MyCommand" in Linux. If the command line refers to file
     * paths, it should use a relative path (relative to the task working
     * directory), or use the Batch provided environment variable
     * (https://docs.microsoft.com/en-us/azure/batch/batch-compute-node-environment-variables).
     */
    @JsonProperty(value = "commandLine", required = true)
    private String commandLine;

    /**
     * The settings for the container under which the Job Release task runs.
     * When this is specified, all directories recursively below the
     * AZ_BATCH_NODE_ROOT_DIR (the root of Azure Batch directories on the node)
     * are mapped into the container, all task environment variables are mapped
     * into the container, and the task command line is executed in the
     * container.
     */
    @JsonProperty(value = "containerSettings")
    private TaskContainerSettings containerSettings;

    /**
     * A list of files that the Batch service will download to the compute node
     * before running the command line.  There is a maximum size for the list
     * of resource files.  When the max size is exceeded, the request will fail
     * and the response error code will be RequestEntityTooLarge. If this
     * occurs, the collection of ResourceFiles must be reduced in size. This
     * can be achieved using .zip files, Application Packages, or Docker
     * Containers.
     * Files listed under this element are located in the task's working
     * directory.
     */
    @JsonProperty(value = "resourceFiles")
    private List<ResourceFile> resourceFiles;

    /**
     * A list of environment variable settings for the Job Release task.
     */
    @JsonProperty(value = "environmentSettings")
    private List<EnvironmentSetting> environmentSettings;

    /**
     * The maximum elapsed time that the Job Release task may run on a given
     * compute node, measured from the time the task starts. If the task does
     * not complete within the time limit, the Batch service terminates it. The
     * default value is 15 minutes. You may not specify a timeout longer than
     * 15 minutes. If you do, the Batch service rejects it with an error; if
     * you are calling the REST API directly, the HTTP status code is 400 (Bad
     * Request).
     */
    @JsonProperty(value = "maxWallClockTime")
    private Period maxWallClockTime;

    /**
     * The minimum time to retain the task directory for the Job Release task
     * on the compute node. After this time, the Batch service may delete the
     * task directory and all its contents.
     * The default is 7 days, i.e. the task directory will be retained for 7
     * days unless the compute node is removed or the job is deleted.
     */
    @JsonProperty(value = "retentionTime")
    private Period retentionTime;

    /**
     * The user identity under which the Job Release task runs.
     * If omitted, the task runs as a non-administrative user unique to the
     * task.
     */
    @JsonProperty(value = "userIdentity")
    private UserIdentity userIdentity;

    /**
     * Get the ID can contain any combination of alphanumeric characters including hyphens and underscores and cannot contain more than 64 characters. If you do not specify this property, the Batch service assigns a default value of 'jobrelease'. No other task in the job can have the same ID as the Job Release task. If you try to submit a task with the same id, the Batch service rejects the request with error code TaskIdSameAsJobReleaseTask; if you are calling the REST API directly, the HTTP status code is 409 (Conflict).
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the ID can contain any combination of alphanumeric characters including hyphens and underscores and cannot contain more than 64 characters. If you do not specify this property, the Batch service assigns a default value of 'jobrelease'. No other task in the job can have the same ID as the Job Release task. If you try to submit a task with the same id, the Batch service rejects the request with error code TaskIdSameAsJobReleaseTask; if you are calling the REST API directly, the HTTP status code is 409 (Conflict).
     *
     * @param id the id value to set
     * @return the JobReleaseTask object itself.
     */
    public JobReleaseTask withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the command line does not run under a shell, and therefore cannot take advantage of shell features such as environment variable expansion. If you want to take advantage of such features, you should invoke the shell in the command line, for example using "cmd /c MyCommand" in Windows or "/bin/sh -c MyCommand" in Linux. If the command line refers to file paths, it should use a relative path (relative to the task working directory), or use the Batch provided environment variable (https://docs.microsoft.com/en-us/azure/batch/batch-compute-node-environment-variables).
     *
     * @return the commandLine value
     */
    public String commandLine() {
        return this.commandLine;
    }

    /**
     * Set the command line does not run under a shell, and therefore cannot take advantage of shell features such as environment variable expansion. If you want to take advantage of such features, you should invoke the shell in the command line, for example using "cmd /c MyCommand" in Windows or "/bin/sh -c MyCommand" in Linux. If the command line refers to file paths, it should use a relative path (relative to the task working directory), or use the Batch provided environment variable (https://docs.microsoft.com/en-us/azure/batch/batch-compute-node-environment-variables).
     *
     * @param commandLine the commandLine value to set
     * @return the JobReleaseTask object itself.
     */
    public JobReleaseTask withCommandLine(String commandLine) {
        this.commandLine = commandLine;
        return this;
    }

    /**
     * Get when this is specified, all directories recursively below the AZ_BATCH_NODE_ROOT_DIR (the root of Azure Batch directories on the node) are mapped into the container, all task environment variables are mapped into the container, and the task command line is executed in the container.
     *
     * @return the containerSettings value
     */
    public TaskContainerSettings containerSettings() {
        return this.containerSettings;
    }

    /**
     * Set when this is specified, all directories recursively below the AZ_BATCH_NODE_ROOT_DIR (the root of Azure Batch directories on the node) are mapped into the container, all task environment variables are mapped into the container, and the task command line is executed in the container.
     *
     * @param containerSettings the containerSettings value to set
     * @return the JobReleaseTask object itself.
     */
    public JobReleaseTask withContainerSettings(TaskContainerSettings containerSettings) {
        this.containerSettings = containerSettings;
        return this;
    }

    /**
     * Get files listed under this element are located in the task's working directory.
     *
     * @return the resourceFiles value
     */
    public List<ResourceFile> resourceFiles() {
        return this.resourceFiles;
    }

    /**
     * Set files listed under this element are located in the task's working directory.
     *
     * @param resourceFiles the resourceFiles value to set
     * @return the JobReleaseTask object itself.
     */
    public JobReleaseTask withResourceFiles(List<ResourceFile> resourceFiles) {
        this.resourceFiles = resourceFiles;
        return this;
    }

    /**
     * Get the environmentSettings value.
     *
     * @return the environmentSettings value
     */
    public List<EnvironmentSetting> environmentSettings() {
        return this.environmentSettings;
    }

    /**
     * Set the environmentSettings value.
     *
     * @param environmentSettings the environmentSettings value to set
     * @return the JobReleaseTask object itself.
     */
    public JobReleaseTask withEnvironmentSettings(List<EnvironmentSetting> environmentSettings) {
        this.environmentSettings = environmentSettings;
        return this;
    }

    /**
     * Get the maxWallClockTime value.
     *
     * @return the maxWallClockTime value
     */
    public Period maxWallClockTime() {
        return this.maxWallClockTime;
    }

    /**
     * Set the maxWallClockTime value.
     *
     * @param maxWallClockTime the maxWallClockTime value to set
     * @return the JobReleaseTask object itself.
     */
    public JobReleaseTask withMaxWallClockTime(Period maxWallClockTime) {
        this.maxWallClockTime = maxWallClockTime;
        return this;
    }

    /**
     * Get the default is 7 days, i.e. the task directory will be retained for 7 days unless the compute node is removed or the job is deleted.
     *
     * @return the retentionTime value
     */
    public Period retentionTime() {
        return this.retentionTime;
    }

    /**
     * Set the default is 7 days, i.e. the task directory will be retained for 7 days unless the compute node is removed or the job is deleted.
     *
     * @param retentionTime the retentionTime value to set
     * @return the JobReleaseTask object itself.
     */
    public JobReleaseTask withRetentionTime(Period retentionTime) {
        this.retentionTime = retentionTime;
        return this;
    }

    /**
     * Get if omitted, the task runs as a non-administrative user unique to the task.
     *
     * @return the userIdentity value
     */
    public UserIdentity userIdentity() {
        return this.userIdentity;
    }

    /**
     * Set if omitted, the task runs as a non-administrative user unique to the task.
     *
     * @param userIdentity the userIdentity value to set
     * @return the JobReleaseTask object itself.
     */
    public JobReleaseTask withUserIdentity(UserIdentity userIdentity) {
        this.userIdentity = userIdentity;
        return this;
    }

}
